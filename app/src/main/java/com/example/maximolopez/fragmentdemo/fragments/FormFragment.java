package com.example.maximolopez.fragmentdemo.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.maximolopez.fragmentdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    EditText edtName;
    EditText edtLastName;

    public interface DataTransfer {
        void TextData(String data);
    }

    DataTransfer dataTransfer;

    public final static String TAG = "FORM_FRAGMENT";

    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            dataTransfer = (DataTransfer) context;
        } catch (Exception ex) {
            throw new ClassCastException(context.toString() + " must implement " + DataTransfer.class.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_form, container, false);

        edtName = v.findViewById(R.id.edt_Name);
        edtLastName = v.findViewById(R.id.edt_last_name);

        Button btnSend = (Button) v.findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String lastName = edtLastName.getText().toString();
                dataTransfer.TextData(String.format("Name: %s; Last Name: %s", name, lastName));
            }
        });

        return v;
    }


}
