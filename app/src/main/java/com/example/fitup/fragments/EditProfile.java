package com.example.fitup.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.fitup.MyDatabaseManager;
import com.example.fitup.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfile extends Fragment {

    private MyDatabaseManager myDatabaseManager;
    LottieAnimationView edit;
    private EditText name,height,weight,age;
    private String[] arr = new String[5];

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfile newInstance(String param1, String param2) {
        EditProfile fragment = new EditProfile();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        name = (EditText) getView().findViewById(R.id.name);
        height = (EditText) getView().findViewById(R.id.height);
        weight = (EditText) getView().findViewById(R.id.weight);
        age = (EditText) getView().findViewById(R.id.age);

        myDatabaseManager.open();

        name.setHint(myDatabaseManager.getName());
        height.setHint(Integer.toString(myDatabaseManager.getHeight()));
        weight.setHint(Integer.toString(myDatabaseManager.getWeight()));
        age.setHint(Integer.toString(myDatabaseManager.getAge()));

        edit = (LottieAnimationView) getView().findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bio = name.getText().toString();
                if (name.getText().toString().length() > 0)
                    bio = name.getText().toString();
                else
                    bio = myDatabaseManager.getName();

                int h;
                if (height.getText().toString().length() > 0)
                    h = Integer.parseInt(height.getText().toString());
                else
                    h = myDatabaseManager.getHeight();
                int w;
                if (weight.getText().toString().length() > 0)
                    w = Integer.parseInt(weight.getText().toString());
                else
                    w = myDatabaseManager.getWeight();
                int a;
                if (age.getText().toString().length() > 0)
                    a = Integer.parseInt(age.getText().toString());
                else
                    a=myDatabaseManager.getAge();

                myDatabaseManager.update(bio,h,w,a);

                myDatabaseManager.close();

                ProfileFragment fragment = new ProfileFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_wrapper, fragment);
                fragmentTransaction.commit();
            }
        });

    }
}