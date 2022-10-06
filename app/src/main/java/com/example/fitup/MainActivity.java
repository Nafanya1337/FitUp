package com.example.fitup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.fitup.databinding.ActivityMainBinding;
import com.example.fitup.fragments.FitFragment;
import com.example.fitup.fragments.FoodFragment;
import com.example.fitup.fragments.HomeFragment;
import com.example.fitup.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs = null;
    ActivityMainBinding binding;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Фиксируем портретное положение

        // ae

        prefs = getSharedPreferences("com.mycompany.appname", MODE_PRIVATE);
        if (prefs.getBoolean("firstrun", true)) {
            Intent intent = new Intent(MainActivity.this, welcome.class);
            startActivity(intent);
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

        navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setItemIconTintList(null);

            switch (item.getItemId())
            {
                case R.id.homeFragment:

                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profileFragment:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.fitFragment:
                    replaceFragment(new FitFragment());
                    break;
                case R.id.foodFragment:
                    replaceFragment(new FoodFragment());
                    break;
            }

            return true;
        });
    }

    public void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_wrapper,fragment);
        fragmentTransaction.commit();
    }

}