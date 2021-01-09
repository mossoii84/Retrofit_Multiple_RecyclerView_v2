package com.example.retrofit_multiple_recyclerview_v2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pub implements RoditelInterface {

    @SerializedName("text")
    @Expose
    private String text;

    public Pub(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
