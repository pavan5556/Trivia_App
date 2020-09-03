package com.pavan.triviaapp.source.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.pavan.triviaapp.source.model.Summary;


@Database(entities = {Summary.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    public abstract SummaryDao summaryDao();



}
