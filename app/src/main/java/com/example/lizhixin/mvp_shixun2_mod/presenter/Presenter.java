package com.example.lizhixin.mvp_shixun2_mod.presenter;

import android.content.Intent;

import com.example.lizhixin.mvp_shixun2_mod.view.View;

public interface Presenter  {
    void onCreate();

    void onStart();//用不上

    void onStop();

    void pause();//用不上

    void attachView(View view);

    void attachIncommingIntent(Intent intent);
}
