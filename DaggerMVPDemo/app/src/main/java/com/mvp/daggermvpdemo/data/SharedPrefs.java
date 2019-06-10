package com.mvp.daggermvpdemo.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * https://android.jlelse.eu/dagger-2-the-simplest-approach-3e23502c4cab
 */
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
