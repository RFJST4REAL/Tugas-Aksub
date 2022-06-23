package com.example.task2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login;//set variabel untuk digunakan di function
    EditText userName, passwordUser;//set variabel untuk digunakan di function
    TextView toRegister;//set variabel untuk digunakan di function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.ButtonClickLogin);//get button login
        toRegister = (TextView)findViewById(R.id.btn_ToRegister);//get text view to href
        userName = findViewById(R.id.et_loginUsername);//get username from edit text
        passwordUser = findViewById(R.id.et_passwordUser);//get password user from password user

        login.setOnClickListener(v -> {//untuk mengubah halaman ke layar
            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);//dari login activity ke main activity
            startActivity(loginIntent);//untuk melakukan login intent dengan start activity
        });

        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);//dari loginactivity
                startActivity(intentRegister);
            }
        });
    }
 }