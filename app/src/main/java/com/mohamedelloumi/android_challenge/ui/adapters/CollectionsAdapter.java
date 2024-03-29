package com.mohamedelloumi.android_challenge.ui.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mohamedelloumi.android_challenge.BR;
import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.models.Collection;

import java.util.List;


public class CollectionsAdapter extends BaseAdapter {

    private List<Collection> collectionList;

    public CollectionsAdapter(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }

    @Override
    public int getCount() {
        return collectionList.size();
    }

    @Override
    public Object getItem(int position) {
        return collectionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        final String collectionImage = collectionList.get(position).getCoverPhoto().getUrls().getThumb();
        System.out.println(collectionImage);
        if (convertView != null) {
            binding = (ViewDataBinding) convertView.getTag();
        } else {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.item_collection, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        }
        binding.setVariable(BR.item, collectionList.get(position));
        return convertView;
    }
}
