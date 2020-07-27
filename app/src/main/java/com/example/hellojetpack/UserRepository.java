package com.example.hellojetpack;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : weixing
 * @date : 2020/7/27 11:30 AM
 */
public class UserRepository {

    private WebService webService;
    private UserDao userDao;
    private Executor executor;

    @SuppressWarnings("AlibabaThreadPoolCreation")
    public UserRepository() {
        this.webService = new Retrofit.Builder().baseUrl("http://apis.juhe.cn").addConverterFactory( GsonConverterFactory.create()).build().create(WebService.class);
        this.userDao = DbManager.getINSTANCE().getUserDao();
        this.executor = Executors.newCachedThreadPool();
    }

    public LiveData<User> getUser(String userId) {
        refreshUser(userId);
        return userDao.findById(userId);
    }

    private void refreshUser(final String userId){

        executor.execute(() -> {
            //这里判断是否最近获取到过user
//                boolean userExists = userDao.hasUser(FRESH_TIMEOUT);
            try {
                Response<User> execute = webService.getUser(userId+"").execute();
                User body = execute.body();
                if (null != userId) {
                    body.setUserId(userId);
                    userDao.saveUser(body);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

//    public static final long FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1);


}
