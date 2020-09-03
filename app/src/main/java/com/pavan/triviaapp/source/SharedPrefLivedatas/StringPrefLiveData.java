package com.pavan.triviaapp.source.SharedPrefLivedatas;

import android.content.SharedPreferences;

public class StringPrefLiveData extends SharedPrefLivedata<String> {

    private SharedPreferences preferences;

    public StringPrefLiveData(SharedPreferences prefs, String key) {
        super(prefs, key);
        preferences = prefs;
    }

    @Override
    String getValueFromPreferences(String key) {
        return preferences.getString(key, null);
    }
}
