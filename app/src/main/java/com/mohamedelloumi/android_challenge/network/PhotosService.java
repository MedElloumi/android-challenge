package com.mohamedelloumi.android_challenge.network;

import com.mohamedelloumi.android_challenge.models.Collection;
import com.mohamedelloumi.android_challenge.models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotosService {
    @GET("photos/random/?")
    Call<List<Photo>> getPhotos(@Query("count") String count,
                                @Query("collections") String collections,
                                     @Query("client_id") String clientId);
}
