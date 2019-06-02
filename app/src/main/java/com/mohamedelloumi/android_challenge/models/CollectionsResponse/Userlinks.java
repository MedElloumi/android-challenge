package com.mohamedelloumi.android_challenge.models.CollectionsResponse;

import com.google.gson.annotations.SerializedName;

public class Userlinks {
    @SerializedName("self")
    private String self;
    @SerializedName("html")
    private String html;
    @SerializedName("photos")
    private String photos;
    @SerializedName("likes")
    private String likes;
    @SerializedName("portfolio")
    private String portfolio;
    @SerializedName("following")
    private String following;
    @SerializedName("followers")
    private String followers;
}
