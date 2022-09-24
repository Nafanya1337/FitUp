package com.example.fitup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.content.Intent;

import android.content.SharedPreferences;
import android.view.*;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView start;
    SharedPreferences prefs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.rectangle_5);
        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);
        if(prefs.getBoolean("firstrun",true))
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, Step1.class);
                    startActivity(intent);
                }
            });
        else
        {
            Intent intent = new Intent(MainActivity.this, home.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (prefs.getBoolean("firstrun", true)) {
            prefs.edit().putBoolean("firstrun", false).commit();
        }
    }
}