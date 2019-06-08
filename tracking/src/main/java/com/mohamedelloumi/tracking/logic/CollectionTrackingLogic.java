package com.mohamedelloumi.tracking.logic;

import android.content.Context;
import android.os.AsyncTask;

import com.mohamedelloumi.tracking.dao.CollectionDao;
import com.mohamedelloumi.tracking.database.TrackingRoomDatabase;
import com.mohamedelloumi.tracking.models.LocalCollection;

import java.util.List;


public class CollectionTrackingLogic {

    public CollectionTrackingLogic() {
    }

    public void insertCollections (List<LocalCollection> localCollections, Context application) {
        TrackingRoomDatabase db = TrackingRoomDatabase.getDatabase(application);
        CollectionDao collectionDao = db.collectionDao();
        new insertCollectionsAsyncTask(collectionDao).execute(localCollections);
    }

    private static class insertCollectionsAsyncTask extends AsyncTask<List<LocalCollection>, Void, Void> {

        private CollectionDao collectionDao;

        private insertCollectionsAsyncTask(CollectionDao collectionDao) {
            this.collectionDao = collectionDao;
        }

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<LocalCollection>... lists) {
            collectionDao.insertCollections(lists[0]);
            return null;
        }
    }
}
