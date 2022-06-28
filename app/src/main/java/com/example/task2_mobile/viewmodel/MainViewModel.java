package com.example.task2_mobile.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.task2_mobile.data.remote.ApiConfig;
import com.example.task2_mobile.data.remote.ApiService;
import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<NbaTeamItemResponseItem>> _nbaTeams = new MutableLiveData<>();
    private LiveData<List<NbaTeamItemResponseItem>> getNbaTeamItems(){
        return _nbaTeams;
    }

    private final ApiService mApiService = ApiConfig.getApiService();

    public void callApi (){
        mApiService.getNbaTeams().enqueue(new Callback<List<NbaTeamItemResponseItem>>() {
            @Override
            public void onResponse(Call<List<NbaTeamItemResponseItem>> call, Response<List<NbaTeamItemResponseItem>> response) {
                if(response.isSuccessful()){
                    _nbaTeams.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<NbaTeamItemResponseItem>> call, Throwable t) {

            }
        });
    }
}
