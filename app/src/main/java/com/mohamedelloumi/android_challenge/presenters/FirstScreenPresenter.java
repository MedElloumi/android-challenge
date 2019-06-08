package com.mohamedelloumi.android_challenge.presenters;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.mohamedelloumi.android_challenge.ApplicationContext;
import com.mohamedelloumi.android_challenge.logic.CollectionsLogic;
import com.mohamedelloumi.android_challenge.models.Collection;
import com.mohamedelloumi.tracking.logic.CollectionTrackingLogic;
import com.mohamedelloumi.tracking.models.LocalCollection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import retrofit2.Response;

public class FirstScreenPresenter implements CollectionsLogic.CollectionsInterface, CollectionTrackingLogic.CollectionTrackingInterface {

    public ObservableArrayList<Collection> collectionsList = new ObservableArrayList<>();
    public ObservableBoolean isLoading = new ObservableBoolean(true);
    public ObservableBoolean isFirstTimeUser = new ObservableBoolean(true);
    private ObservableBoolean isCollectionsSaved = new ObservableBoolean(false);

    public final ObservableField<LocalCollection> featuredLocalCollection = new ObservableField<>();

    public FirstScreenPresenter() {
        CollectionTrackingLogic collectionTrackingLogic = new CollectionTrackingLogic(this);
        collectionTrackingLogic.selectAllLocalCollections(ApplicationContext.get());
    }

    @Override
    public void onCollectionsResponse(Response<List<Collection>> response) {
        isLoading.set(false);
        collectionsList.addAll(Objects.requireNonNull(response.body()));
        if (!isCollectionsSaved.get()) {
            CollectionTrackingLogic collectionTrackingLogic = new CollectionTrackingLogic();
            collectionTrackingLogic.insertCollections(mapCollections(response.body()), ApplicationContext.get());
        }

    }

    @Override
    public void onCollectionsFailure(Throwable t) {
        isLoading.set(false);
    }

    /**
     * Map collections from the unsplash API format to the local collection format {id: 123, visits: 0, image: "http://image.link"}
     * each local collection will start with number of clicks = 0
     *
     * @param collections (unsplash API collections)
     * @return (list of local collections)
     */
    private List<LocalCollection> mapCollections(List<Collection> collections) {
        int initialClicks = 0;
        List<LocalCollection> localCollections = collections.stream()
                .map(collection -> new LocalCollection(collection.getId(), initialClicks, collection.getCoverPhoto().getUrls().getRegular())).collect(Collectors.toList());
        return localCollections;
    }

    @Override
    public void onSelectAllLocalCollectionsResponse(List<LocalCollection> localCollections) {
        if (localCollections.size() == 0) {
            CollectionsLogic collectionsLogic = new CollectionsLogic(this);
            collectionsLogic.returnCollections();
        } else if (localCollections.size() == 6) {
            Integer clicksNumber = localCollections.stream()
                    .map(LocalCollection::getVisits).reduce(0, Integer::sum);
            if (clicksNumber == 0) {
                isCollectionsSaved.set(true);
                CollectionsLogic collectionsLogic = new CollectionsLogic(this);
                collectionsLogic.returnCollections();
            } else {
                isLoading.set(false);
                isFirstTimeUser.set(false);
                LocalCollection localCollection = Collections.max(localCollections, Comparator.comparing(LocalCollection::getVisits));
                featuredLocalCollection.set(localCollection);
            }
        }
    }
}
