package com.example.thirdapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    //private Button btnDatePicker;
    private EditText editTextDate;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button buttonRegister = findViewById(R.id.register);
        Button buttonExit = findViewById(R.id.exit);
        editTextDate = findViewById(R.id.picked_date);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Пользователь успешно зарегистрировался!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void openDialog() {
        java.util.Calendar c = java.util.Calendar.getInstance();

        DatePickerDialog tpd =
                new DatePickerDialog(
                        RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                Log.d("Hello", dayOfMonth + "." + month + "." + year);
                                editTextDate.setText(String.format("%02d.%02d.%04d",dayOfMonth,month,year));
                            }
                        },
                        c.get(java.util.Calendar.YEAR),
                        c.get(java.util.Calendar.MONTH),
                        c.get(java.util.Calendar.DAY_OF_MONTH)
                );
        tpd.show();
    }
}