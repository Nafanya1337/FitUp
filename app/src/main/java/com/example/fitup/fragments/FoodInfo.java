package com.example.fitup.fragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitup.R;

public class FoodInfo extends Fragment {
    ImageView close, search;
    TextView food;


    private FoodInfoViewModel mViewModel;

    public static FoodInfo newInstance() {
        return new FoodInfo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_food_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        close = (ImageView) getView().findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.my_fade_in, R.animator.my_fade_out);
                fragmentTransaction.hide(fragmentManager.findFragmentByTag("INFO"));
                fragmentTransaction.commit();
            }
        });
        food = (TextView) getView().findViewById(R.id.food);
        String str = "http://www.google.com/search?q=как готовить " + food.getText();
        search = (ImageView) getView().findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.animation));
                Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(google);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FoodInfoViewModel.class);
        // TODO: Use the ViewModel
    }

}