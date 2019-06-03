package com.mohamedelloumi.android_challenge.ui.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.databinding.FragmentItemBinding;
import com.mohamedelloumi.android_challenge.presenters.ItemPresenter;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {


    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentItemBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_item, container, false);
        binding.setPresenter(new ItemPresenter());
        return binding.getRoot();
    }

}
