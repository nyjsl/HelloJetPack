package com.example.hellojetpack;

import android.app.Application;

import androidx.room.Room;

/**
 * @author : weixing
 * @date : 2020/7/27 12:22 PM
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbManager.getINSTANCE().init(this);
    }
}
