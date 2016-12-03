package com.gdgvellore.evhunt.Entity.Registration.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdgvellore.evhunt.R;

/**
 * Created by Shuvam Ghosh on 12/3/2016.
 */

public class RegistrationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_registration,container,false);
        return rootView;

    }
}
