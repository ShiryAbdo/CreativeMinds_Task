package com.example.shirya.creativeminds_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

 import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

import static java.security.AccessController.getContext;

public class Shwo_Cach extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Cache_repos_data> dataR;
     adaptor adaptor;
    Realm realm;
    RealmResults<Cache_repos_data> results;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shwo__cach);
        Realm.init( this);
        RealmConfiguration config = new RealmConfiguration
                .Builder( ).deleteRealmIfMigrationNeeded() .build();

        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
          results= realm.where(Cache_repos_data.class).findAllAsync();
          Toast.makeText(getApplicationContext(),
                  results.get(0)+"", Toast.LENGTH_LONG).show();
          dataR=new ArrayList<>();
          recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
          recyclerView.setHasFixedSize(true);
          RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
          recyclerView.setLayoutManager(layoutManager);
          dataR.addAll(results);
          adaptor= new adaptor(dataR,this);
          recyclerView.setAdapter(adaptor);
          adaptor.notifyDataSetChanged();

      }

    private void initViews(){







    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
            realm = null;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        adaptor.notifyDataSetChanged();

    }





}
