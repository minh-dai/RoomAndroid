package com.example.minh_dai.roomandsqlite.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.minh_dai.roomandsqlite.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
