package com.example.shirya.creativeminds_task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by shirya on 03/09/17.
 */

public class repos_data {



    @Required
    @SerializedName("id")
    @Expose
    private  int  id;


    @Required
     @SerializedName("name")
    @Expose
    private String name;


    @Required
     @SerializedName("full_name")
    @Expose
    private String full_name;

    @Required
     @SerializedName("description")
    @Expose
    private String description;

    @Required
     @SerializedName("fork")
    @Expose
    private  Boolean fork;



     @SerializedName("html_url")
    @Expose
    private  String html_url;



    @SerializedName("owner")
    @Expose
    private owner owner;


    public  owner getOwner() {
        return owner;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getFork() {
        return fork;
    }

    public String getHtml_url() {
        return html_url;
    }



}


