package com.mvp.expediademo.http.thingstodo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThingItem {

    @Expose
    @SerializedName("id")
    public String itemId;

    @Expose
    @SerializedName("title")
    public String title;

    @Expose
    @SerializedName("imageUrl")
    public String imageUrl;

    @Expose
    @SerializedName("largeImageURL")
    public String largeImageURL;

    @Expose
    @SerializedName("fromPrice")
    public String fromPrice;


    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public String getFromPrice() {
        return fromPrice;
    }
}
