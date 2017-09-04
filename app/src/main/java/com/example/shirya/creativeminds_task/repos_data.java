package com.example.shirya.creativeminds_task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shirya on 03/09/17.
 */

public class repos_data {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("full_name")
    @Expose
    private String full_name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("fork")
    @Expose
    private  Boolean fork;

    @SerializedName("html_url")
    @Expose
    private  String html_url;

    @SerializedName("html_url")
    @Expose
    private String owner_html_url;

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
