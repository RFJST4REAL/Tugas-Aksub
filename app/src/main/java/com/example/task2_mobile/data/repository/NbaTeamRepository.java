package com.example.task2_mobile.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.task2_mobile.data.local.NbaTeamDao;
import com.example.task2_mobile.data.local.NbaTeamRoomDatabase;
import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NbaTeamRepository {
    private final NbaTeamDao mNbaTeamDao;
    private final ExecutorService mExecutorService;

    public NbaTeamRepository(Application application){
        mExecutorService = Executors.newSingleThreadExecutor();
        NbaTeamRoomDatabase db =   NbaTeamRoomDatabase.getDatabase(application);
        mNbaTeamDao = db.mNbaTeamDao();

    }

    //asynchronus
    public LiveData<List<NbaTeamItemResponseItem>> getNbaItems(){
        return mNbaTeamDao.getNbaTeams();
    }

    //syncchronus -> ui thread
    public void insert(final NbaTeamItemResponseItem nbaTeamItemResponseItem){
        mExecutorService.execute(() -> mNbaTeamDao.insert(nbaTeamItemResponseItem));
    }
}
