package com.example.shirya.creativeminds_task;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<repos_data> data;
    private DataAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
      }


    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadJSON();


    }

    


    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                 Toast.makeText(getApplicationContext(),
                        "Clicled" + response, Toast.LENGTH_LONG).show();
//                ArrayList<repos_data> jsonResponse = response.body();
////                data = new ArrayList<>(Arrays.asList(jsonResponse));
//                adapter = new DataAdapter(jsonResponse, MainActivity.this);
//                recyclerView.setAdapter(adapter);


              response.body();
                Toast.makeText(getApplicationContext(),
                        "Clicled" +   response.body(), Toast.LENGTH_LONG).show();

//                data.clear();
//                try {
//                    List<repos_data> responseBody = response.body();
//                    data = new ArrayList<>();
//                     data.addAll(responseBody);
//                     adapter = new DataAdapter(data, MainActivity.this);
//                    recyclerView.setAdapter(adapter);
//                Toast.makeText(getApplicationContext(),
//                            "onResponse There is an error" , Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//
//                    Toast.makeText(getApplicationContext(),
//                            "onResponse There is an error" , Toast.LENGTH_SHORT).show();
//                     Log.d("onResponse", "There is an error");
//                    e.printStackTrace();
//                }
//                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
