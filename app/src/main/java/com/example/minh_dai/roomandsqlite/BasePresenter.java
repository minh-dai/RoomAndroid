package com.example.minh_dai.roomandsqlite;

public interface BasePresenter<T> {
    void setView(T view);

    void onStart();

    void onStop();
}
