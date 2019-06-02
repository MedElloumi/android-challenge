package com.mohamedelloumi.android_challenge.models.CollectionsResponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Collection {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("published_at")
    private String publishedAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("curated")
    private boolean curated;
    @SerializedName("featured")
    private boolean featured;
    @SerializedName("total_photos")
    private int totalPhotos;
    @SerializedName("private")
    private boolean Private;
    @SerializedName("share_key")
    private String shareKey;
    @SerializedName("tags")
    private ArrayList<Tags> tags = new ArrayList<>();
    @SerializedName("links")
    private Links links;
    @SerializedName("user")
    private User user;
    @SerializedName("cover_photo")
    private CoverPhoto coverPhoto;
    @SerializedName("preview_photos")
    private ArrayList<PreviewPhotos> previewPhotos = new ArrayList<>();

    public CoverPhoto getCoverPhoto() {
        return coverPhoto;
    }
}
