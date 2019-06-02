package com.mohamedelloumi.android_challenge.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

    public interface CategoryService {
    @GET("?")
    Call getCategories(@Query("xyz") String artist,
                       @Query("xyz") String method,
                       @Query("xyz") String format,
                       @Query("xyz") String apiKey);
}
