package com.example.shirya.creativeminds_task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shirya on 05/09/17.
 */

public class owner {
    @SerializedName("html_url")
    @Expose
    private Object html_url;

    public void setHtml_url(Object html_url) {
        this.html_url = html_url;
    }

    public Object getHtml_url() {
        return html_url;
    }
}
