package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolBar;
    EditText editText_id;
    EditText editText_pw;
    Button btnSwitch;
    TextView errorMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toolBar.setTitle("Groceries on the Go!");

        editText_id = findViewById(R.id.editText_id);
        editText_pw = findViewById(R.id.editText_pw);
        errorMsg = findViewById(R.id.errMsg);
        btnSwitch = findViewById(R.id.btnSwitch);


        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", "Yuli Kim");
                startActivity(intent);

//                if (editText_id.getText().toString().equals("admin@example.com") && editText_pw.getText().toString().equals("1234")) {
//                    startActivity(intent);
//                } else {
//                    errorMsg.setText("Invalid email or password. Please try again.");
//                    InputMethodManager imm = (InputMethodManager)
//                            getSystemService(Activity.INPUT_METHOD_SERVICE);
//                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//                }
            }
        });
    }
}