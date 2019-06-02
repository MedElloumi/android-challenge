package com.mohamedelloumi.android_challenge.models;

import java.util.ArrayList;

public class Collection {
    private int id;
    private String title;
    private String description;
    private String publishedAt;
    private String updatedAt;
    private boolean curated;
    private boolean featured;
    private int totalPhotos;
    private boolean Private;
    private String shareKey;
    private ArrayList<Tags> tags = new ArrayList<>();
    private Links links;
    private User user;
    private CoverPhoto coverPhoto;
    private ArrayList<PreviewPhotos> previewPhotos = new ArrayList<>();
}
