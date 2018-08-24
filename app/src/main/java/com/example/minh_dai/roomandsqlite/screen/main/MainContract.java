package com.example.minh_dai.roomandsqlite.screen.main;

import com.example.minh_dai.roomandsqlite.BasePresenter;
import com.example.minh_dai.roomandsqlite.BaseView;
import com.example.minh_dai.roomandsqlite.data.model.Word;

public interface MainContract {

    interface Presenter extends BasePresenter<View>{
        boolean onCLickWordAdd(Word word);

        void onCLickWordShow();
    }

    interface View extends BaseView<Presenter>{
        void failAdd();

        void successAdd();

        void onShowWord();
    }
}
