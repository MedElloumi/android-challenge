package com.mohamedelloumi.android_challenge.utils;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.widget.GridView;

import com.mohamedelloumi.android_challenge.models.CollectionsResponse.Collection;
import com.mohamedelloumi.android_challenge.ui.adapters.CollectionsAdapter;

public class CustomDataBinding {
    @BindingAdapter("items")
    public static void setItems(GridView gridView, ObservableArrayList<Collection> collectionList) {
        CollectionsAdapter collectionsAdapter = new CollectionsAdapter(collectionList, gridView.getContext());
        gridView.setAdapter(collectionsAdapter);
    }
}
