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
    ImageView close, search, salad1;
    TextView food, text;
    String title;
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
        food = (TextView) getView().findViewById(R.id.title);
        text = (TextView) getView().findViewById(R.id.text);
        Bundle bundle = this.getArguments();
        title = bundle.getString("tittle");
        makeText();
        String str = "http://www.google.com/search?q=как готовить " + title;
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


    public void makeText(){
        switch (title){
            case "Борщ":
                text.setText("Знаменитый красный борщ любят за особенный аромат, удивительный вкус и насыщенный цвет. Идеальное сочетание овощей придают красному борщу тот индивидуальный вкус, благодаря которому он входит в список самых известных супов мира.");
                break;
            case "Куриный суп":
                text.setText("Очень сытный, нежный и ароматный куриный суп,\nне требующий много времени для приготовления. Рецепт супа с плавленым сыром очень прост,\nно замечательный вкус супчика оценят даже злостные\n«нелюбители» первых блюд.");
                break;
            case "Щи":
                text.setText("Щи – национальное русское блюдо. Отличаются кислым вкусом, создаваемым квашеной капустой, обычно используемой в щах.");
                break;
        }
        food.setText(title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FoodInfoViewModel.class);
        // TODO: Use the ViewModel
    }

}