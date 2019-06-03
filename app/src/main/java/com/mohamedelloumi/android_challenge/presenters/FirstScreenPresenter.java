package com.mohamedelloumi.android_challenge.presenters;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import com.mohamedelloumi.android_challenge.logic.CollectionsLogic;
import com.mohamedelloumi.android_challenge.models.Collection;

import java.util.List;
import java.util.Objects;

import retrofit2.Response;

public class FirstScreenPresenter implements CollectionsLogic.CollectionsInterface {
    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableBoolean isFirstTimeUser = new ObservableBoolean(true);

    public ObservableArrayList<Collection> collectionsList = new ObservableArrayList<>();

    public FirstScreenPresenter() {
        CollectionsLogic collectionsLogic = new CollectionsLogic(this);
        collectionsLogic.returnCollections();
    }

    @Override
    public void onCollectionsResponse(Response<List<Collection>> response) {
        isLoading.set(false);
        collectionsList.addAll(Objects.requireNonNull(response.body()));
    }

    @Override
    public void onCollectionsFailure(Throwable t) {
        isLoading.set(false);
    }
}
