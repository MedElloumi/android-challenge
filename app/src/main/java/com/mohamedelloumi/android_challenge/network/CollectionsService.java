package com.mohamedelloumi.android_challenge.network;

import com.mohamedelloumi.android_challenge.models.CollectionsResponse.Collection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CollectionsService {
    @GET("collections/?")
    Call <List<Collection>> getCollections(@Query("per_page") String perPage,
                                           @Query("client_id") String clientId);
}
