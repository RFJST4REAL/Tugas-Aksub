package com.example.task2_mobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.task2_mobile.data.remote.NbaTeamItemResponseItem;
import com.example.task2_mobile.databinding.ActivityMainBinding;
import com.example.task2_mobile.databinding.FragmentSecondpageMainBinding;
import com.example.task2_mobile.viewmodel.MainViewModel;
import com.example.task2_mobile.viewmodel.MainViewModelFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondpageMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondpageMainFragment<NbaTeamAdapter> extends Fragment {
    private FragmentSecondpageMainBinding mBinding;
    private List<String> nbaTeamsItemName;
    private MainViewModel mMainViewModel;
    private NbaTeamAdapter mNbaTeamAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentSecondpageMainBinding.inflate(inflater, container, false);

        nbaTeamsItemName = new ArrayList<>();

        mMainViewModel = new ViewModelProvider(this, new MainViewModelFactory(getActivity().getApplication())).get(MainViewModel.class);
        mMainViewModel.callApi();
        mMainViewModel.getNbaTeamItems().observe(getViewLifecycleOwner(), nbaTeamItemResponseItems -> {
            mNbaTeamAdapter = new ViewTeamAdapter(NbaTeamItemResponseItem);
            mNbaTeamAdapter.setOnItemClickCallBack(new ViewTeamAdapter.OnItemClickCallBack(){
                @Override
                public void onInsertClick(NbaTeamItemResponseItem nbaTeamItemResponseItem){
                    mMainViewModel.insertNbaItem(nbaTeamItemResponseItem);
                }
            });
            mBinding.rvNbaTeams.setAdapter(new ViewTeamAdapter(nbaTeamItemResponseItems));
        });
        mBinding.btnOfflineMode.setOnClickListener(view -> startActivity(new Intent(this, OfflineActivity.class)));


        return mBinding.getRoot();
    }

}