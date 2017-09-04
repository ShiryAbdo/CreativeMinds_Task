package com.example.shirya.creativeminds_task;

 import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Arrays;
 import java.util.List;

 import io.realm.Realm;
 import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<repos_data> data;
    private DataAdapter adapter ;
    private Realm mRealm;

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
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<repos_data>> call = request.getJSON();
        call.enqueue(new Callback<List<repos_data>>() {
            @Override
            public void onResponse(Call<List<repos_data>> call, Response<List<repos_data>> response) {
//                Toast.makeText(getApplicationContext(),
//                        "Clicled" + response.body(), Toast.LENGTH_LONG).show();

                 List<repos_data> responseBody = response.body();
                    data = new ArrayList<>();
                     data.addAll(responseBody);
                     adapter = new DataAdapter(data, MainActivity.this);
                    recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<repos_data>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Error", Toast.LENGTH_LONG).show();
                Log.d("Error",t.getMessage());
            }
        });
    }

    

}
