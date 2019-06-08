package com.mohamedelloumi.tracking.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mohamedelloumi.tracking.dao.CollectionDao;
import com.mohamedelloumi.tracking.models.LocalCollection;

@Database(entities = {LocalCollection.class}, version = 1, exportSchema = false)
public abstract class TrackingRoomDatabase extends RoomDatabase {

    public abstract CollectionDao collectionDao();

    private static TrackingRoomDatabase INSTANCE;

    public static TrackingRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (TrackingRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TrackingRoomDatabase.class, "tracking_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
