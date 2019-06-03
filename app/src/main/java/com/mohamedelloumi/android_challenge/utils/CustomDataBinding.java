package com.mohamedelloumi.android_challenge.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.models.Collection;
import com.mohamedelloumi.android_challenge.models.Photo;
import com.mohamedelloumi.android_challenge.ui.activities.MainActivity;
import com.mohamedelloumi.android_challenge.ui.adapters.CollectionsAdapter;
import com.mohamedelloumi.android_challenge.ui.adapters.PhotosAdapter;
import com.mohamedelloumi.android_challenge.ui.fragments.ImagesFragment;
import com.mohamedelloumi.android_challenge.ui.fragments.SinglePhotoFragment;
import com.squareup.picasso.Picasso;

public class CustomDataBinding {
    @BindingAdapter("items")
    public static void setItems(GridView gridView, ObservableArrayList<Collection> collectionList) {
        CollectionsAdapter collectionsAdapter = new CollectionsAdapter(collectionList);
        gridView.setAdapter(collectionsAdapter);
    }

    @BindingAdapter("photos_items")
    public static void setPhotosItems(GridView gridView, ObservableArrayList<Photo> photoList) {
        PhotosAdapter photosAdapter = new PhotosAdapter(photoList);
        gridView.setAdapter(photosAdapter);
    }

    @BindingAdapter("img")
    public static void setImg(ImageView imageView, String source) {
        if ((source != null) && (!source.isEmpty())) {
            Picasso.get().load(source).into(imageView);
        }
    }

    @BindingAdapter("onCategoryClicked")
    public static void setOnCategoryClicked(ImageView imageView, int id) {
        // imageView.setOnClickListener(v -> Toast.makeText(imageView.getContext(), "you clicked on the following category " + id, Toast.LENGTH_LONG).show());
        imageView.setOnClickListener(v -> openPhotosFragment(imageView.getContext(), String.valueOf(id)));
    }

    @BindingAdapter("onPhotoClicked")
    public static void setOnPhotoClicked(ImageView imageView, String id) {
        // imageView.setOnClickListener(v -> Toast.makeText(imageView.getContext(), "you clicked on the following category " + id, Toast.LENGTH_LONG).show());
        imageView.setOnClickListener(v -> openSinglePhotoFragment(imageView.getContext(), id));
    }

    private static void openPhotosFragment(Context context, String collectionId) {
        MainActivity mainActivity = (MainActivity) context;
        ImagesFragment imagesFragment = new ImagesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("collectionId", collectionId);
        imagesFragment.setArguments(bundle);
        mainActivity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, imagesFragment)
                .addToBackStack(null)
                .commit();
    }

    private static void openSinglePhotoFragment(Context context, String photoId) {
        MainActivity mainActivity = (MainActivity) context;
        SinglePhotoFragment singlePhotoFragment = new SinglePhotoFragment();
        Bundle bundle = new Bundle();
        bundle.putString("photoId", photoId);
        singlePhotoFragment.setArguments(bundle);
        mainActivity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, singlePhotoFragment)
                .addToBackStack(null)
                .commit();
    }

}
