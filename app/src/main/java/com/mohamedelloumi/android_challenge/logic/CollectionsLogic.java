package com.mohamedelloumi.android_challenge.logic;

import com.mohamedelloumi.android_challenge.configuration.Settings;
import com.mohamedelloumi.android_challenge.models.CollectionsResponse.Collection;
import com.mohamedelloumi.android_challenge.network.Client;
import com.mohamedelloumi.android_challenge.network.CollectionsService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionsLogic {
    private CollectionsService collectionsService = Client.getRetrofit().create(CollectionsService.class);

    private CollectionsInterface collectionsInterface;

    public CollectionsLogic(CollectionsInterface collectionsInterface) {
        this.collectionsInterface = collectionsInterface;
    }

    /**
     * will return Collections from the Unsplash API
     *
     * @param
     * @return void
     */
    public void returnCollections() {
        Call<List<Collection>> call = collectionsService.getCollections(Settings.defaultPerPage, Settings.clientId);
        call.enqueue(new Callback<List<Collection>>() {


            @Override
            public void onResponse(@NotNull Call<List<Collection>> call, @NotNull Response<List<Collection>> response) {
                collectionsInterface.onCollectionsResponse(response);
            }

            @Override
            public void onFailure(@NotNull Call<List<Collection>> call, @NotNull Throwable t) {
                collectionsInterface.onCollectionsFailure(t);

            }
        });
    }

    public interface CollectionsInterface {
        void onCollectionsResponse(Response<List<Collection>> response);

        void onCollectionsFailure(Throwable t);
    }
}
