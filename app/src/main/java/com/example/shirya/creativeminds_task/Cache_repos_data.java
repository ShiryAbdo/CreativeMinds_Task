package com.example.shirya.creativeminds_task;

import io.realm.RealmModel;
import io.realm.RealmObject;

import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by shirya on 04/09/17.
 */

public class Cache_repos_data  extends RealmObject  implements RealmModel{

//
//    @PrimaryKey
//    private long id;

    @Required
    private String name;

    @Required
    private String full_name;

    @Required
    private String description;
    @Required
    private String fork;

    @Required
    private String html_url;

    @Required
    private String owner_html_url;


//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getOwner_html_url() {
        return owner_html_url;
    }

    public void setOwner_html_url(String owner_html_url) {
        this.owner_html_url = owner_html_url;
    }
}
