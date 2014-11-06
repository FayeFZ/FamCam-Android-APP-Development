package com.lilysamimi.famcamproject;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentAccessAddress extends DialogFragment {

    public FragmentAccessAddress() {
        // Empty constructor required for DialogFragment
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_address_book, container);
        return view;
    }




}
