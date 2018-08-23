package com.example.minh_dai.roomandsqlite.screen;

import android.content.Context;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private Context mContext;

    public MainPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void setView(MainContract.View view) {
        view = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
