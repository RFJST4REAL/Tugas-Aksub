package com.example.task2_mobile.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;


@Database(entities = {
        NbaTeamItemResponseItem.class
}, version = 1)
public abstract class NbaTeamRoomDatabase extends RoomDatabase {
    public abstract NbaTeamDao NbaTeamDao();

    public NbaTeamRoomDatabase(){

    }
    private static NbaTeamRoomDatabase INSTANCE;

    public static NbaTeamRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            //bikin database
            synchronized (NbaTeamRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        NbaTeamRoomDatabase.class,
                        "nba_database"
                        ).build();
            }

        }
        return INSTANCE;
    }
}
