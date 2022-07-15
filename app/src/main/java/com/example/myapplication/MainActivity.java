package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolBar;
    EditText editText_id;
    EditText editText_pw;
    Button btnSwitch;
    TextView errorMsg;

    SharedPreferences pref;
    CheckBox checkBox;

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
        checkBox = findViewById(R.id.checkBox);

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", "Yuli Kim");
                startActivity(intent);

                if (editText_id.getText().toString().equals("admin@example.com") && editText_pw.getText().toString().equals("1234")) {
                    startActivity(intent);
                } else {
                    errorMsg.setText("Invalid email or password. Please try again.");
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                }

                saveData(editText_id.getText().toString(), editText_pw.getText().toString());
            }
        });
        loadData();
    }

    void saveData(String id, String pw) {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editer = pref.edit();

        editer.putString("myId", id);
        editer.putString("myPw", pw);

        boolean state = checkBox.isChecked();
        editer.putBoolean("state", state);
        editer.commit();
    }
    void loadData() {
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        String strId = pref.getString("myId", "");
        editText_id.setText(strId);
        String strPs = pref.getString("myPw", "");
        editText_pw.setText(strPs);

        boolean cbState = pref.getBoolean("state", false);
        checkBox.setChecked(cbState);
    }
}