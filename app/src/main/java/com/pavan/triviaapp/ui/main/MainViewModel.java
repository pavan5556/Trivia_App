package com.pavan.triviaapp.ui.main;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pavan.triviaapp.source.Repository;
import com.pavan.triviaapp.source.SharedPrefLivedatas.StringPrefLiveData;
import com.pavan.triviaapp.source.model.Summary;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Boolean> positionMutableLivedata = new MutableLiveData<>();
    private MutableLiveData<String> appbarTitleMutableLiveData = new MutableLiveData<>();

    public void setTitle(String title) {
        appbarTitleMutableLiveData.postValue(title);
    }

    public LiveData<String> getTitle() {
        return appbarTitleMutableLiveData;
    }

    public void nextClicked(boolean position) {
        positionMutableLivedata.postValue(position);
    }

    public MutableLiveData<Boolean> getposition() {
        return positionMutableLivedata;
    }

    public void saveMatch(Summary summary, Context context) {
        Repository.getInstance().saveSummaryToDb(summary, context);
    }

    public LiveData<String> getName(SharedPreferences preferences) {
        return new StringPrefLiveData(preferences, "name");

    }

    public LiveData<String> getAnswer1(SharedPreferences preferences) {
        return new StringPrefLiveData(preferences, "answer1");

    }

    public LiveData<String> getAnswer2(SharedPreferences preferences) {
        return new StringPrefLiveData(preferences, "answer2");

    }

}
