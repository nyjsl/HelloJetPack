package com.example.hellojetpack;

import android.app.Application;

import androidx.room.Room;

/**
 * @author : weixing
 * @date : 2020/7/27 12:23 PM
 */
public class DbManager {

    private static final DbManager INSTANCE = new DbManager();

    private UserDataBase userDataBase;

    private DbManager(){

    }

    UserDao getUserDao(){
        return userDataBase.userDao();
    }

    public static DbManager getINSTANCE() {
        return INSTANCE;
    }

    public void init(Application app){
        userDataBase = Room.databaseBuilder(app, UserDataBase.class, "database-name").build();
    }

}
