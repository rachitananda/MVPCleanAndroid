package com.mvp.expediademo.http.thingstodo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult {

    @SerializedName("total")
    @Expose
    public Integer total;

    @SerializedName("activities")
    @Expose
    public List<ThingItem> activities;

    @Expose
    @SerializedName("isLocationRedirected")
    public Boolean isLocationRedirected;

    @Expose
    @SerializedName("distanceUnit")
    public String distanceUnit;

    @Expose
    @SerializedName("regionId")
    public String regionId;

    @Expose
    @SerializedName("destination")
    public String destination;

    @Expose
    @SerializedName("fullName")
    public String fullName;

    @Expose
    @SerializedName("startDate")
    public String startDate;

    @Expose
    @SerializedName("endDate")
    public String endDate;

    @Expose
    @SerializedName("dateAdjusted")
    public Boolean dateAdjusted;

    @Expose
    @SerializedName("currencyCode")
    public String currencyCode;

    public Integer getTotal() {
        return total;
    }

    public List<ThingItem> getActivities() {
        return activities;
    }

    public Boolean getLocationRedirected() {
        return isLocationRedirected;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public String getRegionId() {
        return regionId;
    }

    public String getDestination() {
        return destination;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Boolean getDateAdjusted() {
        return dateAdjusted;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
