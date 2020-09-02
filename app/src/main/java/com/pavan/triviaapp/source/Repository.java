package com.pavan.triviaapp.source;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.pavan.triviaapp.source.data.Dummy;
import com.pavan.triviaapp.source.data.local.DatabaseClient;
import com.pavan.triviaapp.source.data.local.SummaryDao;
import com.pavan.triviaapp.source.model.Options;
import com.pavan.triviaapp.source.model.Question;
import com.pavan.triviaapp.source.model.Summary;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static Repository repository;

    private Repository() {
    }


    public static Repository getInstance() {
        if (repository == null)
            repository = new Repository();
        return repository;
    }

    public List<Question> getQustions() {
        return Dummy.getQuestionList();
    }

    public List<Options> getOptions() {
        return Dummy.getOptionsList();
    }


    public void saveSummaryToDb(final Summary summary, Context context) {
        final SummaryDao summaryDao = DatabaseClient.getInstance(context).getAppDatabase().summaryDao();
        DatabaseClient.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                summaryDao.insertSummary(summary);
            }
        });
    }

    public LiveData<List<Summary>> getAllSummary(Context context) {
        return DatabaseClient.getInstance(context).getAppDatabase().summaryDao().getAllGameSummary();
    }
}
