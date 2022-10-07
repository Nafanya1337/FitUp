package com.example.fitup.fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.fitup.DatabaseHelper;
import com.example.fitup.MyDatabaseManager;
import com.example.fitup.Person;
import com.example.fitup.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;
import java.util.stream.Stream;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private LottieAnimationView switcher;
    Boolean darkThemeOn = false;
    TextView bio, height, weight, age;
    String bio_,height_,weight_,age_;
    private MyDatabaseManager myDatabaseManager;
    LottieAnimationView edit;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabaseManager = new MyDatabaseManager(getActivity());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bio = (TextView) getView().findViewById(R.id.Bio);
        height = (TextView) getView().findViewById(R.id.height);
        weight = (TextView) getView().findViewById(R.id.weight);
        age = (TextView) getView().findViewById(R.id.age);

        myDatabaseManager.open();

        Person person = new Person();
        myDatabaseManager.insert(person.getName(),person.getSurname(),person.getWeight(),person.getHeight(),person.getAge());
        bio.setText(myDatabaseManager.getName());

        height.setText(Integer.toString(myDatabaseManager.getHeight()) + " см.");
        weight.setText(Integer.toString(myDatabaseManager.getWeight()) + " кг.");
        age.setText(Integer.toString(myDatabaseManager.getAge()) + " лет");

        myDatabaseManager.close();

        edit = (LottieAnimationView) getView().findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditProfile fragment = new EditProfile();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        return v;
    }

    private boolean fileExists(Context _context, String _filename) {
        File temp = _context.getFileStreamPath(_filename);
        if(temp == null || !temp.exists()) {
            return false;
        }
        return true;
    }

}


