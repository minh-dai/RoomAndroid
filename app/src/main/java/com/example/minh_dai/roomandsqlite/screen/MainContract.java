package com.example.minh_dai.roomandsqlite.screen;

import com.example.minh_dai.roomandsqlite.BasePresenter;
import com.example.minh_dai.roomandsqlite.BaseView;

public interface MainContract {

    interface Presenter extends BasePresenter<View>{

    }

    interface View extends BaseView<Presenter>{

    }
}
