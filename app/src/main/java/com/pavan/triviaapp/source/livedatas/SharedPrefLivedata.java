package com.pavan.triviaapp.source.livedatas;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;



abstract class SharedPrefLivedata<T> extends LiveData<T> {

    private SharedPreferences prefs;
    private String key;

    public SharedPrefLivedata(SharedPreferences prefs, String key) {
        this.prefs = prefs;
        this.key = key;
    }

    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (SharedPrefLivedata.this.key.equals(key)) {
                setValue(getValueFromPreferences(key));
            }
        }
    };
    abstract T getValueFromPreferences(String key);
    @Override
    protected void onActive() {
        super.onActive();
        setValue(getValueFromPreferences(key));
        prefs.registerOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    @Override
    protected void onInactive() {
        prefs.unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
        super.onInactive();
    }


}