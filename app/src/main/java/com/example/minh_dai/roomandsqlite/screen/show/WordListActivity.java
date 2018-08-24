package com.example.minh_dai.roomandsqlite.screen.show;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.minh_dai.roomandsqlite.R;
import com.example.minh_dai.roomandsqlite.data.model.Word;
import com.example.minh_dai.roomandsqlite.util.WordViewModel;

import java.util.List;

public class WordListActivity extends AppCompatActivity implements WordListContract.View{

    private RecyclerView mRecyclerView;
    private WordListContract.Presenter mPresenter;
    private WordAdapter mAdapter;
    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
        initComponent();
    }

    private void initComponent() {
        mRecyclerView = findViewById(R.id.recyclerview);

        mPresenter = new WordListPresenter(this);
        mPresenter.setView(this);

        mAdapter = new WordAdapter(this);

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getLiveData().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                mAdapter.setList(words);
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
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
}
