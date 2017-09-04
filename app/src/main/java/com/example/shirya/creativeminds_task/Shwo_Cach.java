package com.example.shirya.creativeminds_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

import static java.security.AccessController.getContext;

public class Shwo_Cach extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Cache_repos_data> data;
     private Realm mRealm;

    Realm realm;
    ArrayList<String> spacecrafts;
     RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shwo__cach);
        mRealm = Realm.getInstance(this);
        initViews();
    }

    private void initViews(){
//        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//
////        recyclerView.setAdapter(new MyListAdapter(mRealm.allObjects(Cache_repos_data.class)));
//        RealmResults<Cache_repos_data> cache_repos_datas =mRealm.allObjects(Cache_repos_data.class);
//        adaptor adp = new adaptor(cache_repos_datas,this);
//
//        recyclerView.setAdapter(adp);

        // 'realm' is a field variable
        realm = Realm.getInstance(this);
        RealmResults<Cache_repos_data> toDoItems = realm
                .where(Cache_repos_data.class)
                .findAllSorted("id", Sort.ASCENDING);
        MyListAdapter toDoRealmAdapter = new MyListAdapter(this, toDoItems, true, true);
        RealmRecyclerView realmRecyclerView = (RealmRecyclerView) findViewById(R.id.realm_recycler_view);
        realmRecyclerView.setAdapter(toDoRealmAdapter);


//        // 'realm' is a field variable
//         RealmResults<Cache_repos_data> toDoItems = mRealm
//                .where(Cache_repos_data.class)
//                 .findAllSorted("id", Sort.ASCENDING);
//        MyListAdapter toDoRealmAdapter = new MyListAdapter(this, toDoItems, true, true);
////        RealmRecyclerView realmRecyclerView = (RealmRecyclerView) findViewById(R.id.realm_recycler_view);
//        recyclerView.setAdapter(toDoRealmAdapter);



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRealm != null) {
            mRealm.close();
            mRealm = null;
        }
    }





}