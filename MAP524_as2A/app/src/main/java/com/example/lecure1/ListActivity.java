package com.example.lecure1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        txtView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("name");

        txtView.setText(str);

    }
}