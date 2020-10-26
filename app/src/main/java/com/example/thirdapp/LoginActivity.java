package com.example.thirdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editPhone = findViewById(R.id.phone);
        EditText editPassword = findViewById(R.id.password);
        Button buttonLogin = findViewById(R.id.login);
        Button buttonExit = findViewById(R.id.exit);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editPhone.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Заполните поле Телефон!", Toast.LENGTH_LONG).show();
                } else if (editPassword.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Заполните поле Пин-код!", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}