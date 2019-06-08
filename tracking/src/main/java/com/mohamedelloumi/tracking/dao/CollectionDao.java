package com.mohamedelloumi.tracking.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mohamedelloumi.tracking.models.LocalCollection;

import java.util.List;

@Dao
public interface CollectionDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertCollections(List<LocalCollection> localCollections);

    @Query("UPDATE collection_table SET visits= visits + 1 WHERE id = :collectionId")
    void updateCollection( int collectionId);

    @Query("SELECT * FROM collection_table")
    List<LocalCollection> selectAllLocalCollections();

}
