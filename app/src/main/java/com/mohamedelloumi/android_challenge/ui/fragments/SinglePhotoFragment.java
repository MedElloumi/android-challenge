package com.mohamedelloumi.android_challenge.ui.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.databinding.FragmentSinglePhotoBinding;
import com.mohamedelloumi.android_challenge.presenters.SinglePhotoPresenter;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class SinglePhotoFragment extends Fragment {


    public SinglePhotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentSinglePhotoBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_single_photo, container, false);
        String photoId = null;
        if (getArguments() != null) {
            photoId = (getArguments()).getString("photoId");
        }
        binding.setPresenter(new SinglePhotoPresenter(photoId));
        return binding.getRoot();
    }

}
