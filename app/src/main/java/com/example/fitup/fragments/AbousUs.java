package com.example.fitup.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.example.fitup.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AbousUs#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AbousUs extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AbousUs() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AbousUs.
     */
    // TODO: Rename and change types and number of parameters
    public static AbousUs newInstance(String param1, String param2) {
        AbousUs fragment = new AbousUs();
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

    public void openGit(View view){
        String str = "https://github.com/Nafanya1337";
        view.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.animation));
        Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
        startActivity(google);
    }

    public void openVK(View view){
        String str = "https://vk.com/nfnaaa";
        view.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.animation));
        Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
        startActivity(google);
    }

    public void openTG(View view){
        String str = "https://t.me/m_if0";
        view.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.animation));
        Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
        startActivity(google);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_abous_us, container, false);
    }
}