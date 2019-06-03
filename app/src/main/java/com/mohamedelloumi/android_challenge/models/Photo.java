package com.mohamedelloumi.android_challenge.models;

import com.google.gson.annotations.SerializedName;
import com.mohamedelloumi.android_challenge.models.CollectionsResponse.CoverPhotoLinks;
import com.mohamedelloumi.android_challenge.models.CollectionsResponse.Urls;
import com.mohamedelloumi.android_challenge.models.CollectionsResponse.User;
import com.mohamedelloumi.android_challenge.models.PhotosResponse.Exif;

import java.util.ArrayList;

public class Photo {
    @SerializedName("id")
    private String id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("color")
    private String color;
    @SerializedName("description")
    private String description;
    @SerializedName("alt_description")
    private String altDescription;
    @SerializedName("urls")
    private Urls urls;
    @SerializedName("links")
    private CoverPhotoLinks links;
    @SerializedName("categories")
    private ArrayList<String> categories = new ArrayList<>();
    @SerializedName("sponsored")
    private boolean sponsored;
    @SerializedName("sponsored_by")
    private String sponsoredBy;
    @SerializedName("sponsored_impressions_id")
    private int sponsoredImpressionsId;
    @SerializedName("likes")
    private int likes;
    @SerializedName("liked_by_user")
    private boolean likedByUser;
    @SerializedName("current_user_collections")
    private ArrayList<String> currentUserCollections = new ArrayList<>();
    @SerializedName("user")
    private User user;
    @SerializedName("exif")
    private Exif exif;
    @SerializedName("views")
    private int views;
    @SerializedName("downloads")
    private int downloads;

    public Urls getUrls() {
        return urls;
    }
}
