package com.example.task2_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;
import com.example.task2_mobile.databinding.ActivityOfflineBinding;
import com.example.task2_mobile.viewmodel.OfflineViewModel;

public class OfflineActivity extends AppCompatActivity {

    private ActivityOfflineBinding mBinding;
    private OfflineViewModel mOfflineViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityOfflineBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mOfflineViewModel = new OfflineViewModel(getApplication());

        mBinding.rvNbaTeams.setLayoutManager(new LinearLayoutManager(this));
        mOfflineViewModel.getOfflineData().observe(this,nbaTeamItemResponseItems ->{
            mBinding.rvNbaTeams.setAdapter(new ViewTeamAdapter(NbaTeamItemResponseItem));
        } );
    }
}