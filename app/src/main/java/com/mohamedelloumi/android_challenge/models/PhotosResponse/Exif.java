package com.mohamedelloumi.android_challenge.models.PhotosResponse;

import com.google.gson.annotations.SerializedName;

public class Exif {
    @SerializedName("make")
    private String make;
    @SerializedName("model")
    private String model;
    @SerializedName("exposure_time")
    private String exposure_time;
    @SerializedName("aperture")
    private String aperture;
    @SerializedName("focal_length")
    private String focal_length;
    @SerializedName("iso")
    private int iso;
}
