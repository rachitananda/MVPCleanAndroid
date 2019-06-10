package com.mvp.expediademo.data;

import android.content.SharedPreferences;

import javax.inject.Inject;


public class SharedPrefs {

    private SharedPreferences mSharedPreferences;

    @Inject
    public SharedPrefs(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void putData(String key, int data) {
        mSharedPreferences.edit().putInt(key,data).apply();
    }

    public int getData(String key) {
        return mSharedPreferences.getInt(key,0);
    }
}
