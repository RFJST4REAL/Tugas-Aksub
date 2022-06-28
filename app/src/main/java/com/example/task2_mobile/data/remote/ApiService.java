package com.example.task2_mobile.data.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("nbateams")
    Call<List<NbaTeamItemResponseItem>> getNbaTeams();
}
