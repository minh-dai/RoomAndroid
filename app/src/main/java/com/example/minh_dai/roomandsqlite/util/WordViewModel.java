package com.example.minh_dai.roomandsqlite.util;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.minh_dai.roomandsqlite.data.model.Word;
import com.example.minh_dai.roomandsqlite.data.source.WordsRepository;
import com.example.minh_dai.roomandsqlite.data.source.local.WordLocalDataSource;
import com.example.minh_dai.roomandsqlite.data.source.local.WordRoomDatabase;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordsRepository mRepository;
    private LiveData<List<Word>> mLiveData;

    public WordViewModel(@NonNull Application application) {
        super(application);
        WordRoomDatabase wordRoomDatabase = WordRoomDatabase.getInstance(application.getApplicationContext());
        mRepository =
                WordsRepository.getInstance(
                        WordLocalDataSource.getnstance(wordRoomDatabase.mWordDao()));

        mLiveData = mRepository.getAllWord();
    }

    public LiveData<List<Word>> getLiveData() {
        return mLiveData;
    }

    public void insert(Word word) { mRepository.addWord(word); }
}
