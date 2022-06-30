package com.example.task2_mobile.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;
import com.example.task2_mobile.data.repository.NbaTeamRepository;

import java.util.List;

public class OfflineViewModel extends ViewModel {
    private NbaTeamRepository mNbaTeamRepository;

    public OfflineViewModel(Application application){
        mNbaTeamRepository = new NbaTeamRepository(application);
    }

    public LiveData<List<NbaTeamItemResponseItem>>getOfflineData(){
        return mNbaTeamRepository.getNbaItems();
    }
}
