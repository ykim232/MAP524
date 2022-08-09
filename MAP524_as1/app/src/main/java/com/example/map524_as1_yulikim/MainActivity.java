package com.example.map524_as1_yulikim;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.EmailAddress);
        email.setAutofillHints(View.AUTOFILL_HINT_PASSWORD);

        EditText password = findViewById(R.id.Password);
        password.setAutofillHints(View.AUTOFILL_HINT_PASSWORD);
    }

}