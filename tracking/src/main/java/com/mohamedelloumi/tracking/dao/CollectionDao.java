package com.mohamedelloumi.tracking.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import com.mohamedelloumi.tracking.models.LocalCollection;

import java.util.List;

@Dao
public interface CollectionDao {

    @Insert
    public void insertCollections(List<LocalCollection> localCollections);

}
