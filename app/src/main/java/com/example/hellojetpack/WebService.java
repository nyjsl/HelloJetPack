package com.example.hellojetpack;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author : weixing
 * @date : 2020/7/27 11:12 AM
 */
public interface WebService {

    @GET("/mobile/Example/query.php")
    Call<User> getUser(@Query("phoneNo") String phoneNo);
}
