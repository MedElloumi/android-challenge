package com.mohamedelloumi.android_challenge.ui.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.databinding.FragmentMostViewedCategoriesBinding;
import com.mohamedelloumi.android_challenge.presenters.MostViewedCategoriesPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostViewedCategoriesFragment extends Fragment {


    public MostViewedCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentMostViewedCategoriesBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_most_viewed_categories, container, false);
        binding.setPresenter(new MostViewedCategoriesPresenter());
        return binding.getRoot();
    }

}
