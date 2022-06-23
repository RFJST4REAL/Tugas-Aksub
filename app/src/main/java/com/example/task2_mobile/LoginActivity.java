package com.example.task2_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login;//set variabel untuk digunakan di function
    EditText userName, passwordUser;//set variabel untuk digunakan di function
    TextView toRegister;//set variabel untuk digunakan di function
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.ButtonClickLogin);//get button login
        toRegister = (TextView)findViewById(R.id.btn_ToRegister);//get text view to href
        userName = findViewById(R.id.et_loginUsername);//get username from edit text
        passwordUser = findViewById(R.id.et_passwordUser);//get password user from password user
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        login.setOnClickListener(v -> {//untuk mengubah halaman ke layar
            if(!userName.getText().toString().equals(sharedPref.getString("account_userName", "")))
            {
                Toast.makeText(LoginActivity.this, "Username Invalid", Toast.LENGTH_SHORT).show();
            }
            else if(!passwordUser.getText().toString().equals(sharedPref.getString("account_password", "")))
            {
                Toast.makeText(LoginActivity.this, "Password Invalid", Toast.LENGTH_SHORT).show();
            }
            else if(userName.getText().toString().equals(sharedPref.getString("account_userName", "")) && passwordUser.getText().toString().equals(sharedPref.getString("account_password", "")))
            {
                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);//dari login activity ke main activity
                loginIntent.putExtra("account_userName", sharedPref.getString("account_userName", ""));
                startActivity(loginIntent);//untuk melakukan login intent dengan start activity
            }
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