package com.mohamedelloumi.android_challenge.presenters;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import com.mohamedelloumi.android_challenge.ApplicationContext;
import com.mohamedelloumi.android_challenge.logic.CollectionsLogic;
import com.mohamedelloumi.android_challenge.models.Collection;
import com.mohamedelloumi.tracking.logic.CollectionTrackingLogic;
import com.mohamedelloumi.tracking.models.LocalCollection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import retrofit2.Response;

public class FirstScreenPresenter implements CollectionsLogic.CollectionsInterface {

    public ObservableArrayList<Collection> collectionsList = new ObservableArrayList<>();
    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableBoolean isFirstTimeUser = new ObservableBoolean(true);

    public FirstScreenPresenter() {
        CollectionsLogic collectionsLogic = new CollectionsLogic(this);
        collectionsLogic.returnCollections();
    }

    @Override
    public void onCollectionsResponse(Response<List<Collection>> response) {
        isLoading.set(false);
        collectionsList.addAll(Objects.requireNonNull(response.body()));

        CollectionTrackingLogic collectionTrackingLogic = new CollectionTrackingLogic();
        collectionTrackingLogic.insertCollections(mapCollections(response.body()), ApplicationContext.get());
    }

    @Override
    public void onCollectionsFailure(Throwable t) {
        isLoading.set(false);
    }

    /**
     * Map collections from the unsplash API format to the local collection format {id: 123 visits: 0}
     * each local collection will start with number of visits = 0
     * @param collections
     * @return
     */
    private List<LocalCollection> mapCollections(List<Collection> collections) {
        int initialClicks = 0;
        List<LocalCollection> localCollections = collections.stream()
                .map(collection -> new LocalCollection(collection.getId(), initialClicks)).collect(Collectors.toList());
        return localCollections;
    }

}
