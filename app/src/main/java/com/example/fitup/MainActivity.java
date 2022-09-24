package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.content.SharedPreferences;
import android.view.*;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("com.mycompany.appname", MODE_PRIVATE);
        if (prefs.getBoolean("firstrun", true)){
                Intent intent = new Intent(MainActivity.this, welcome.class);
                startActivity(intent);
        }
    }
}