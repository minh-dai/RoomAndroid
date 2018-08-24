package com.example.minh_dai.roomandsqlite.screen.show;

import android.app.Activity;

import com.example.minh_dai.roomandsqlite.util.WordViewModel;

public class WordListPresenter implements WordListContract.Presenter {

    private WordListContract.View view;
    private WordViewModel mWordViewModel;

    public WordListPresenter(Activity context) {
       // mWordViewModel = ViewModelProviders.of(context).get(WordViewModel.class);
    }

    @Override
    public void setView(WordListContract.View view) {
        this.view = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

}
