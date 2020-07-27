package com.example.hellojetpack;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/**
 * @author : weixing
 * @date : 2020/7/27 10:31 AM
 */
public class UserProfileViewModel extends ViewModel {

    private SavedStateHandle savedStateHandle;

    private String userId;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private LiveData<User> user;

    private UserRepository userRepository;


    public String getUserId() {
        return userId;
    }

    public LiveData<User> getUser() {
        Log.e("tag","getUsercalled");
        return userRepository.getUser(userId);
    }

    public UserProfileViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
        userRepository = new UserRepository();
    }
}
