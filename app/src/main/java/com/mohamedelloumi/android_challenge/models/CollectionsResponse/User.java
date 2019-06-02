package com.mohamedelloumi.android_challenge.models.CollectionsResponse;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("username")
    private String username;
    @SerializedName("name")
    private String name;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("twitter_username")
    private String twitterUsername;
    @SerializedName("portfolio_url")
    private String portfolioUrl;
    @SerializedName("bio")
    private String bio;
    @SerializedName("location")
    private String location;
    @SerializedName("links")
    private Userlinks links;
    @SerializedName("profile_image")
    private ProfileImage profileImage;
    @SerializedName("instagram_username")
    private String instagramUsername;
    @SerializedName("total_collections")
    private int totalCollections;
    @SerializedName("total_likes")
    private int totalLikes;
    @SerializedName("total_photos")
    private int totalPhotos;
    @SerializedName("accepted_tos")
    private boolean acceptedTos;

}
