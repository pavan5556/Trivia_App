package com.pavan.triviaapp.source;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.pavan.triviaapp.source.local.DatabaseClient;
import com.pavan.triviaapp.source.local.SummaryDao;
import com.pavan.triviaapp.source.model.Summary;

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
