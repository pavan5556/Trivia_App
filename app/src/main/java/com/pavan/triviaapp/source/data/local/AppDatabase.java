package com.pavan.triviaapp.source.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pavan.triviaapp.source.model.Summary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Summary.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    public abstract SummaryDao summaryDao();



}
