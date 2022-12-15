package com.example.fitup.fragments;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.fitup.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodSoups#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodSoups extends Fragment {
    ImageView back, salad1, salad2, salad3;
    ImageView img;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodSoups() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodSoups.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodSoups newInstance(String param1, String param2) {
        FoodSoups fragment = new FoodSoups();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back = (ImageView) getView().findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.animation));
                FoodFragment fragment = new FoodFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.my_fade_in, R.animator.my_fade_out);
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.commit();
            }
        });

        salad1 = (ImageView) getView().findViewById(R.id.salad1);
        salad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tittle", "Борщ"); // Put anything what you want

                FoodInfo fragment2 = new FoodInfo();
                fragment2.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_wrapper, fragment2, "INFO")
                        .commit();
            }
        });

        salad2 = (ImageView) getView().findViewById(R.id.salad2);
        salad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tittle", "Куриный суп"); // Put anything what you want

                FoodInfo fragment2 = new FoodInfo();
                fragment2.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_wrapper, fragment2, "INFO")
                        .commit();
            }
        });

        salad3 = (ImageView) getView().findViewById(R.id.salad3);
        salad3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tittle", "Щи"); // Put anything what you want

                FoodInfo fragment2 = new FoodInfo();
                fragment2.setArguments(bundle);

                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.fl_wrapper, fragment2, "INFO")
                        .commit();
            }
        });
    }

    public void openSoup(){
        return;
        /*String name = "";
        if (view.getId() == R.id.salad1){
            name = "Борщ";
        }
        if (view.getId() == R.id.salad2){
            name = "Куриный суп";
        }
        if (view.getId() == R.id.salad3){
            name = "Щи";
        }
        Bundle bundle = new Bundle();
        bundle.putString("tittle", name); // Put anything what you want

        FoodInfo fragment2 = new FoodInfo();
        fragment2.setArguments(bundle);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.fl_wrapper, fragment2)
                .commit();
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_soups, container, false);
    }
}