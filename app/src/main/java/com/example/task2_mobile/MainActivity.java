package com.example.task2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Logout = findViewById(R.id.btn_Logout);



        Logout.setOnClickListener(v-> {
            Intent LogoutIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(LogoutIntent);
        });
//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Login Success!!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}