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
//repos?page=3&per_page=100>; rel="next",
//<https://api.github.com/user/repos?page=50&per_page=100>; rel="last"
//?access_token=<5f5371a6c64979d0dd84da2342be4a2f101bf5d6>
