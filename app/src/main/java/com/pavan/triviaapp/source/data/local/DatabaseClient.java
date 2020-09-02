package com.pavan.triviaapp.source.data.local;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseClient {

    private Context context;
    private static DatabaseClient databaseClient;

    //our app database object
    private AppDatabase appDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    private DatabaseClient(Context context) {
        this.context = context;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "trivia").build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (databaseClient == null) {
            databaseClient = new DatabaseClient(mCtx);
        }
        return databaseClient;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

}
