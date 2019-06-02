package com.mohamedelloumi.android_challenge.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.models.CollectionsResponse.Collection;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionsAdapter extends BaseAdapter {

    private List<Collection> collectionList;
    private Context context;

    public CollectionsAdapter(List<Collection> collectionList, Context context) {
        this.collectionList = collectionList;
        this.context = context;
    }

    public static class ViewHolder {
        protected @BindView(R.id.itemCollectionImageView)
        ImageView itemCollectionImageView;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
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
        ViewHolder holder;
        final String collectionImage = collectionList.get(position).getCoverPhoto().getUrls().getThumb();
        System.out.println(collectionImage);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_collection, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        if ((collectionImage != null) && (!collectionImage.isEmpty())) {
            Picasso.get().load(collectionImage).into(holder.itemCollectionImageView);
        }
        return convertView;
    }
}
