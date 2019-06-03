package com.mohamedelloumi.android_challenge.ui.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.databinding.FragmentImagesBinding;
import com.mohamedelloumi.android_challenge.presenters.ImagesPresenter;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesFragment extends Fragment {


    public ImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentImagesBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_images, container, false);
        String clientId = null;
        if (getArguments() != null) {
            clientId = (getArguments()).getString("collectionId");
        }
        binding.setPresenter(new ImagesPresenter(clientId));
        return binding.getRoot();
    }

}
