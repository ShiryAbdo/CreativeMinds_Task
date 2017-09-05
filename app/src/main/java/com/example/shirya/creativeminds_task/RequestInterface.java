package com.example.shirya.creativeminds_task;



 import java.util.List;

 import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shirya on 03/09/17.
 */

public interface RequestInterface {
    @GET("users/square/repos")
    Call<List<repos_data>>  getJSON();
}
