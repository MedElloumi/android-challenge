package com.mohamedelloumi.android_challenge.presenters;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import com.mohamedelloumi.android_challenge.logic.PhotosLogic;
import com.mohamedelloumi.android_challenge.models.Photo;

import java.util.List;
import java.util.Objects;

import retrofit2.Response;

public class ImagesPresenter implements PhotosLogic.PhotosInterface {
    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableArrayList<Photo> photosList = new ObservableArrayList<>();

    public ImagesPresenter(String collectionId) {
        PhotosLogic photosLogic = new PhotosLogic(this);
        photosLogic.returnPhotos(collectionId);
    }

    @Override
    public void onPhotosResponse(Response<List<Photo>> response) {
        isLoading.set(false);
        photosList.addAll(Objects.requireNonNull(response.body()));
    }

    @Override
    public void onPhotosFailure(Throwable t) {
        isLoading.set(false);
    }
}
