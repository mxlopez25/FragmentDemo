package com.example.maximolopez.fragmentdemo.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maximolopez.fragmentdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    public final static String TAG = "FORM_FRAGMENT";

    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_form, container, false);
        return v;
    }

}
