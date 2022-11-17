package com.example.fitup.fragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.fitup.R;

public class NewFood extends Fragment {

    TextView text;
    EditText edit_text;
    ImageView close;

    private NewFoodFruitViewModel mViewModel;

    public static NewFood newInstance() {
        return new NewFood();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_food_fruit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        edit_text = (EditText) getView().findViewById(R.id.editname);
        text = (TextView) getView().findViewById(R.id.name_of_food);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setVisibility(View.INVISIBLE);
                edit_text.setVisibility(View.VISIBLE);
                edit_text.setText(text.getText());
                edit_text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edit_text.setVisibility(View.INVISIBLE);
                        text.setVisibility(View.VISIBLE);
                        text.setText(edit_text.getText());
                        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                });
            }
        });

        close = (ImageView) getView().findViewById(R.id.close2);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.my_fade_in, R.animator.my_fade_out);
                fragmentTransaction.hide(fragmentManager.findFragmentByTag("NEW_FOOD"));
                fragmentTransaction.commit();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewFoodFruitViewModel.class);
        // TODO: Use the ViewModel
    }

}