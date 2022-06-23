package com.example.task2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Logout;
    TextView Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logout = findViewById(R.id.btn_Logout);
        Username = findViewById(R.id.tv_Username);

        Intent intent = getIntent();
        String tempUserName = intent.getStringExtra("account_userName");

        Username.setText(tempUserName);

        Logout.setOnClickListener(v-> {
            Intent LogoutIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(LogoutIntent);
        });
    }

}