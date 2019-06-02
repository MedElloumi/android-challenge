package com.mohamedelloumi.android_challenge.models;

import java.util.ArrayList;

public class CoverPhoto {
    private String id;
    private String createdAt;
    private String updatedAt;
    private int width;
    private int height;
    private String color;
    private String description;
    private String altDescription;
    private Urls urls;
    private CoverPhotoLinks links;
    private ArrayList<String> categories = new ArrayList<>();
    private boolean sponsored;
    private String sponsoredBy;
    private int sponsoredImpressionsId;
    private int likes;
    private boolean likedByUser;
    private ArrayList<String> currentUserCollections = new ArrayList<>();
    private User user;

}
