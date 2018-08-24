package com.example.minh_dai.roomandsqlite.screen.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minh_dai.roomandsqlite.R;
import com.example.minh_dai.roomandsqlite.data.model.Word;
import com.example.minh_dai.roomandsqlite.screen.show.WordListActivity;
import com.example.minh_dai.roomandsqlite.util.WordViewModel;

public class MainActivity extends AppCompatActivity
        implements MainContract.View, View.OnClickListener {

    private MainContract.Presenter mPresenter;
    private EditText mEdtWord;
    private Button mButtonAdd;
    private Button mButtonShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initConponent();
        onClickButtons();
    }

    private void onClickButtons() {
        mButtonShow.setOnClickListener(this);
        mButtonAdd.setOnClickListener(this);
    }

    private void initView() {
        mEdtWord = findViewById(R.id.edtWord);
        mButtonAdd = findViewById(R.id.btnAddWord);
        mButtonShow = findViewById(R.id.btnShow);
    }

    private void initConponent() {
        mPresenter = new MainPresenter(this);
        mPresenter.setView(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddWord:
                String edtcontext = mEdtWord.getText().toString();
                Word word = new Word(edtcontext);
                new AddWordAsynctask().execute(word);
                break;
            case R.id.btnShow:
                mPresenter.onCLickWordShow();
                break;
        }
    }

    @Override
    public void failAdd() {
        Toast.makeText(this, "Fail Add", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successAdd() {
        Toast.makeText(this, "Success Add" + mEdtWord.getText().toString() , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowWord() {
        Intent intent = new Intent(this, WordListActivity.class);
        startActivity(intent);
    }

    private class AddWordAsynctask extends AsyncTask<Word,Void,Boolean>{
        private Word word1;
        @Override
        protected Boolean doInBackground(Word... word) {
            word1 = word[0];
            boolean addSuccess = mPresenter.onCLickWordAdd(word1);
            return addSuccess;
        }

        @Override
        protected void onPostExecute(final Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean){
                successAdd();
            }else {
                failAdd();
            }
        }
    }
}
