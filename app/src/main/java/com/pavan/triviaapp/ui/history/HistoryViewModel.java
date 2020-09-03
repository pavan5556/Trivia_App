package com.pavan.triviaapp.ui.history;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pavan.triviaapp.source.Repository;
import com.pavan.triviaapp.source.model.Summary;

import java.util.List;

public class HistoryViewModel extends ViewModel {

    public LiveData<List<Summary>> getAllSummary(Context context) {
        return Repository.getInstance().getAllSummary(context);
    }
}
