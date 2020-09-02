package com.pavan.triviaapp.ui.main;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pavan.triviaapp.source.Repository;
import com.pavan.triviaapp.source.livedatas.StringPrefLiveData;
import com.pavan.triviaapp.source.model.Options;
import com.pavan.triviaapp.source.model.Question;
import com.pavan.triviaapp.source.model.Summary;

import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Boolean> positionMutableLivedata = new MutableLiveData<>();

    public List<Question> getQuestions() {
        return Repository.getInstance().getQustions();
    }

    public List<Options> getOptions() {
        return Repository.getInstance().getOptions();
    }

    public void nextClicked(boolean position) {
        positionMutableLivedata.postValue(position);
    }

    public MutableLiveData<Boolean> getposition() {
        return positionMutableLivedata;
    }

    public void saveMatch(Summary summary, Context context) {
        Repository.getInstance().saveSummaryToDb(summary,context);
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

//    public MutableLiveData<Answer> getAnswer() {
//        return answerMutableLiveData;
//    }
}
