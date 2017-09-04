package com.example.shirya.creativeminds_task;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by shirya on 04/09/17.
 */

public class RealmHelper {

    Realm realm;
    public RealmHelper(Realm realm) {
        this.realm = realm;
    }
    //WRITE
    public void save(final Cache_repos_data spacecraft)
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Cache_repos_data s=realm.copyToRealm(spacecraft);
            }
        });
    }
    //READ
    public ArrayList<Cache_repos_data> retrieve()
    {
        ArrayList<Cache_repos_data> spacecraftNames=new ArrayList<>();
        RealmResults<Cache_repos_data> spacecrafts=realm.where(Cache_repos_data.class).findAll();
        for(Cache_repos_data s:spacecrafts)
        {
            spacecraftNames.add(s);
        }
        return spacecraftNames;
    }
}
