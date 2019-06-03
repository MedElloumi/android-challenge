package com.mohamedelloumi.android_challenge.logic;

import com.mohamedelloumi.android_challenge.configuration.Settings;
import com.mohamedelloumi.android_challenge.models.Photo;
import com.mohamedelloumi.android_challenge.network.Client;
import com.mohamedelloumi.android_challenge.network.PhotosService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosLogic {
    private PhotosService collectionsService = Client.getRetrofit().create(PhotosService.class);

    private PhotosInterface photosInterface;

    public PhotosLogic(PhotosInterface photosInterface) {
        this.photosInterface = photosInterface;
    }

    public void returnPhotos(String collectionId) {
        Call<List<Photo>> call = collectionsService.getPhotos(Settings.count, collectionId, Settings.clientId);
        call.enqueue(new Callback<List<Photo>>() {


            @Override
            public void onResponse(@NotNull Call<List<Photo>> call, @NotNull Response<List<Photo>> response) {
                photosInterface.onPhotosResponse(response);
            }

            @Override
            public void onFailure(@NotNull Call<List<Photo>> call, @NotNull Throwable t) {
                photosInterface.onPhotosFailure(t);
            }
        });
    }

    public interface PhotosInterface {
        void onPhotosResponse(Response<List<Photo>> response);

        void onPhotosFailure(Throwable t);
    }
}
