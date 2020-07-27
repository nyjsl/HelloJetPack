package com.example.hellojetpack;


import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author : weixing
 * @date : 2020/7/27 11:52 AM
 */
@Database(entities = {User.class},version = 1,exportSchema=false)
public abstract class UserDataBase extends RoomDatabase {

    abstract UserDao userDao();

}
