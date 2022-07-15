package com.example.lecure1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnLogin;
    ListView lstView;
    EditText editText_id;
    EditText editText_pw;
    TextView errorMsg;

    String[] stores = {"Walmart", "Freshco", "Canadian Superstore", "Food Basics", "Dollarama", "Dollar Tree", "Spinneys"};
    String[] address = {"12 Leslie, Toronto, ON", "34 Marham Rd, Markham, ON", "55 Adam Road, Richmond Hill, ON", "9 Young Road, Newmarket, ON",
            "34 MarkhamRd Markham, ON", "55 Adam Road Richmond Hill, ON", "9 Young Road, Newmarket, ON"};
    int[] open = {1, 0, 1, 1, 1, 0, 0};
    int[] logo = {R.drawable.walmart, R.drawable.freshco, R.drawable.canadiansuperstore, R.drawable.dollarama, R.drawable.dollertree, R.drawable.spinneys};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_activity);
        setContentView(R.layout.toolbar_file);

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        editText_id = findViewById(R.id.editTextTextEmailAddress);
        editText_pw = findViewById(R.id.editTextTextPassword);
        errorMsg = findViewById(R.id.errormsg);

        btnLogin = findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
//                String temp = editText_id.getText().toString();
                intent.putExtra("name", "Hello, Yuli Kim");

                if (!editText_id.equals("admin@example.com") || editText_pw.equals(1234)) {
                    errorMsg.setText("Invalid email or password. Please try again.");

                } else {
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    startActivity(intent);
                }
            }
        });

//        lstView = (ListView) findViewById(R.id.lstView);
//        GroceryAdapter groceryAdapter = new GroceryAdapter(this, stores, address, open, logo);
//        lstView.setAdapter(groceryAdapter);

    }

}