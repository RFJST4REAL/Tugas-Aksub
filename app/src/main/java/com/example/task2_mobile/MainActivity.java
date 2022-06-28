package com.example.task2_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.task2_mobile.databinding.ActivityMainBinding;
import com.example.task2_mobile.viewmodel.MainViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button Logout;
    TextView Username;
    TabLayout tabLayout;
    ViewPager2 viewPagerMain;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logout = findViewById(R.id.btn_Logout);
        Username = findViewById(R.id.tv_Username);
        tabLayout = findViewById(R.id.Tab_LayoutMain);
        viewPagerMain = findViewById(R.id.viewPagerMain);

        Intent intent = getIntent();
        String tempUserName = intent.getStringExtra("account_userName");

        Username.setText(tempUserName);

        Logout.setOnClickListener(v-> {
            Intent LogoutIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(LogoutIntent);
        });

        setViewPagerMain(viewPagerMain);
        new TabLayoutMediator(tabLayout, viewPagerMain, ((tab, position) -> {
            tab.setText(pageAdapter.getFragmentTitle(position));
        })).attach();


    }

    private void setViewPagerMain(ViewPager2 viewPagerMain){
        if(pageAdapter == null){
            pageAdapter  = new PageAdapter(this);
            pageAdapter.addFragment(new HomeActivity(), "Home");
            pageAdapter.addFragment(new SecondpageMainFragment(), "Second");
            viewPagerMain.setAdapter(pageAdapter);
        }
    }

}