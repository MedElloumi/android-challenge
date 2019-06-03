package com.mohamedelloumi.android_challenge.ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mohamedelloumi.android_challenge.BR;
import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.models.Photo;

import java.util.List;


public class PhotosAdapter extends BaseAdapter {

    private List<Photo> photosList;

    public PhotosAdapter(List<Photo> photosList) {
        this.photosList = photosList;
    }

    @Override
    public int getCount() {
        return photosList.size();
    }

    @Override
    public Object getItem(int position) {
        return photosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding binding;
        final String photoImage = photosList.get(position).getUrls().getThumb();
        System.out.println(photoImage);
        if (convertView != null) {
            binding = (ViewDataBinding) convertView.getTag();
        } else {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.item_photo, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        }
        binding.setVariable(BR.item, photosList.get(position));
        return convertView;
    }
}

