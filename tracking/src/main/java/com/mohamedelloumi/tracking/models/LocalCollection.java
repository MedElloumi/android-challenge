package com.mohamedelloumi.tracking.models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "collection_table")
public class LocalCollection {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "visits")
    private int visits;

    public LocalCollection(int id, int visits) {
        this.id = id;
        this.visits = visits;
    }

    public int getId() {
        return id;
    }

    public int getVisits() {
        return visits;
    }
}
