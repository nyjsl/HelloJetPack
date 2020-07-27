package com.example.hellojetpack;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * @author : weixing
 * @date : 2020/7/27 11:59 AM
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveUser(User user);

    @Query("SELECT * FROM user WHERE userId = :userId")
    LiveData<User> findById(String userId);

}
