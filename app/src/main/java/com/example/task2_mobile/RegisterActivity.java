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

public class RegisterActivity extends AppCompatActivity {

    Button Register;
    TextView ToLogin;
    EditText UserName_register, Name_Register, Password_Register;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Register = findViewById(R.id.ButtonClickRegister);
        ToLogin = (TextView)findViewById(R.id.btn_ToLogin);
        UserName_register = findViewById(R.id.et_RegisterUserName);
        Name_Register = findViewById(R.id.et_RegisterName);
        Password_Register = findViewById(R.id.et_Password_Register);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        Register.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("account_userName", UserName_register.getText().toString());
            editor.putString("account_name", Name_Register.getText().toString());
            editor.putString("account_password", Password_Register.getText().toString());
            editor.apply();

            Toast.makeText(RegisterActivity.this, "Register Successful",Toast.LENGTH_SHORT).show();

//            Intent registerIntent = new Intent(RegisterActivity.this, MainActivity.class);
//            startActivity(registerIntent);
        });
        ToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}