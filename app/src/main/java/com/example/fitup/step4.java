package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class step4 extends AppCompatActivity {

    ImageView start;
    SharedPreferences prefs = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);
        start = findViewById(R.id.next4);
        prefs = getSharedPreferences("com.mycompany.appname", MODE_PRIVATE);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(step4.this, MainActivity.class);
                prefs.edit().putBoolean("firstrun", false).commit();
                startActivity(intent);
            }
        });
    }
}