package com.example.minh_dai.roomandsqlite.screen.main;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.minh_dai.roomandsqlite.R;
import com.example.minh_dai.roomandsqlite.data.model.Word;
import com.example.minh_dai.roomandsqlite.data.source.WordsRepository;
import com.example.minh_dai.roomandsqlite.data.source.local.WordLocalDataSource;
import com.example.minh_dai.roomandsqlite.data.source.local.WordRoomDatabase;
import com.example.minh_dai.roomandsqlite.util.WordViewModel;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private Context mContext;
    private WordsRepository mWordsRepository;
    private WordRoomDatabase mWordRoomDatabase;

    public MainPresenter(Context mContext) {
        this.mContext = mContext;
        mWordRoomDatabase = WordRoomDatabase.getInstance(mContext);
        mWordsRepository =
                WordsRepository.getInstance(
                        WordLocalDataSource.getnstance(mWordRoomDatabase.mWordDao()));
    }

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public boolean onCLickWordAdd(Word word) {
        if (checkFail(word)) {
            mWordsRepository.addWord(word);
            return true;
        }
        return false;
    }

    private boolean checkFail(Word word) {
        return word.getWord().equals("") ? false : true;
    }

    @Override
    public void onCLickWordShow() {
        view.onShowWord();
    }
}
