package com.example.shirya.creativeminds_task;

import com.android.volley.ResponseDelivery;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shirya on 03/09/17.
 */

public interface RequestInterface {
    @GET("/square/repos")
    Call<JSONResponse>  getJSON();
}
