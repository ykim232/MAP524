package com.example.myapplication;

import static com.example.myapplication.R.drawable.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    Toolbar toolBar;
    RecyclerView recyclerView;
    String[] fruits;
    String[] addresses;
    List<Integer> imageList = new ArrayList<>();
    List<Boolean> openList = new ArrayList<>();
    //    Integer[] images = {R.drawable.walmart, R.drawable.freshco, R.drawable.canadiansuperstore, R.drawable.dollarama, R.drawable.dollertree, R.drawable.spinneys};
    //    Boolean[] open = {true, false, true, true, true, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");

//        toolBar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolBar);
//        toolBar.setTitle("Hello, " + str);
//        getSupportActionBar().setLogo(R.drawable.grocery_logo);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello, " + str);

        fruits = getResources().getStringArray(R.array.fruits);
        addresses = getResources().getStringArray(R.array.addresses);

        imageList.add(walmart);
        imageList.add(freshco);
        imageList.add(canadiansuperstore);
        imageList.add(dollarama);
        imageList.add(dollertree);
        imageList.add(spinneys);
        imageList.add(walmart);
        imageList.add(freshco);
        imageList.add(canadiansuperstore);
        imageList.add(dollarama);
        imageList.add(dollertree);
        imageList.add(spinneys);

        openList.add(true);
        openList.add(false);
        openList.add(true);
        openList.add(true);
        openList.add(false);
        openList.add(false);
        openList.add(true);
        openList.add(false);
        openList.add(true);
        openList.add(true);
        openList.add(false);
        openList.add(false);

        MyAdapter myAdapter = new MyAdapter(this, fruits, addresses, imageList, openList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.addItemDecoration(new RecyclerViewDecoration(10));
    }
}
