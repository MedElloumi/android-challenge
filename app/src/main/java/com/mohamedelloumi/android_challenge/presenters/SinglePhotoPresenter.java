package com.mohamedelloumi.android_challenge.presenters;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.mohamedelloumi.android_challenge.logic.PhotosLogic;
import com.mohamedelloumi.android_challenge.models.Photo;

import retrofit2.Response;

public class SinglePhotoPresenter implements PhotosLogic.PhotoInterface {
    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public final ObservableField<Photo> photo = new ObservableField<>();

    public SinglePhotoPresenter(String photoId) {
        PhotosLogic photosLogic = new PhotosLogic(this);
        photosLogic.returnPhoto(photoId);
    }

    @Override
    public void onPhotoResponse(Response<Photo> response) {
        isLoading.set(false);
        photo.set(response.body());
    }

    @Override
    public void onPhotoFailure(Throwable t) {
        isLoading.set(false);
    }
}
