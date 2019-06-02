package com.mohamedelloumi.android_challenge.models.CollectionsResponse;

import com.google.gson.annotations.SerializedName;

public class Urls {
    @SerializedName("raw")
    private String raw;
    @SerializedName("full")
    private String full;
    @SerializedName("regular")
    private String regular;
    @SerializedName("small")
    private String small;
    @SerializedName("thumb")
    private String thumb;

    public String getFull() {
        return full;
    }

    public String getThumb() {
        return thumb;
    }
}
