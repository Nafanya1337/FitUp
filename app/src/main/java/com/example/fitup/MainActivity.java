package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.view.*;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.rectangle_5);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Step1.class);
                startActivity(intent);
            }
        });
        }
    }