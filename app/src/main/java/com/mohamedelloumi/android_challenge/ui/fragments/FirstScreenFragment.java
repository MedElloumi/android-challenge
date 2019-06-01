package com.mohamedelloumi.android_challenge.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.databinding.DataBindingUtil;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.databinding.FragmentFirstScreenBinding;
import com.mohamedelloumi.android_challenge.presenters.FirstScreenPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstScreenFragment extends Fragment {


    public FirstScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFirstScreenBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_first_screen, container, false);
        binding.setPresenter(new FirstScreenPresenter());
        return binding.getRoot();
    }

}
