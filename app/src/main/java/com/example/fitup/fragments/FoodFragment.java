package com.example.fitup.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.fitup.AndroidFileFunctions;
import com.example.fitup.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    ImageView salades, desserts, soups, fruicts, second;
    TextView b0;
    LinearLayout breakfast;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView searchtext;
    private SearchView search;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
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
        breakfast = (LinearLayout) getView().findViewById(R.id.breakfast);
        b0 = (TextView) getView().findViewById(R.id.breakfast_null);
        search = (SearchView) getView().findViewById(R.id.search_bar);
        salades = getView().findViewById(R.id.salades);
        salades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodSalades fragment = new FoodSalades();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.commit();
            }
        });
        desserts = getView().findViewById(R.id.desserts);
        desserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodDessert fragment = new FoodDessert();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.commit();
            }
        });
        soups = getView().findViewById(R.id.soups);
        soups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodSoups fragment = new FoodSoups();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.commit();
            }
        });

        fruicts = getView().findViewById(R.id.fruicts);
        fruicts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodFruicts fragment = new FoodFruicts();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.commit();
            }
        });

        second = getView().findViewById(R.id.second);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondDish fragment = new SecondDish();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.commit();
            }
        });

        //searchtext.setTextColor(Color.BLACK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }
}