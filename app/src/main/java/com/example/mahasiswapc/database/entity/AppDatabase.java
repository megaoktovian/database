package com.example.mahasiswapc.database.entity;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {sekolah.class} , version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract sekolahDAO dao();
    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context){
        if(appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class,
                    "dbUser").allowMainThreadQueries().build();

        return appDatabase;
    }

    public static void destroyInstance() {
        appDatabase = null;
    }
}
