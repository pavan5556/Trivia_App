package com.pavan.triviaapp.source.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.pavan.triviaapp.source.model.Summary;

import java.util.List;

@Dao
public interface SummaryDao {

    @Query("Select * FROM summary")
    LiveData<List<Summary>> getAllGameSummary();

    @Insert
    void insertSummary(Summary summary);
}
