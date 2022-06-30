package com.example.task2_mobile.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;

import java.util.List;

@Dao
public interface NbaTeamDao {
    //masukin data ke database
    @Insert
    void insert(NbaTeamItemResponseItem NbaTeamItemResponseItem);

    //Baca dari database
    @Query("SELECT * from NbaTeamItemResponseItem")
    LiveData<List<NbaTeamItemResponseItem>> getNbaTeams();



}
