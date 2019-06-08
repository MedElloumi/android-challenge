package com.mohamedelloumi.tracking.logic;

import android.content.Context;
import android.os.AsyncTask;

import com.mohamedelloumi.tracking.dao.CollectionDao;
import com.mohamedelloumi.tracking.database.TrackingRoomDatabase;
import com.mohamedelloumi.tracking.models.LocalCollection;

import java.util.List;


public class CollectionTrackingLogic {

    private CollectionTrackingInterface collectionTrackingInterface;

    public CollectionTrackingLogic() {
    }

    public CollectionTrackingLogic(CollectionTrackingInterface collectionTrackingInterface) {
        this.collectionTrackingInterface = collectionTrackingInterface;
    }

    public void insertCollections(List<LocalCollection> localCollections, Context application) {
        TrackingRoomDatabase db = TrackingRoomDatabase.getDatabase(application);
        CollectionDao collectionDao = db.collectionDao();
        new insertCollectionsAsyncTask(collectionDao).execute(localCollections);
    }

    public void updateCollection(int collectionId, Context application) {
        TrackingRoomDatabase db = TrackingRoomDatabase.getDatabase(application);
        CollectionDao collectionDao = db.collectionDao();
        new updateCollectionAsyncTask(collectionDao).execute(collectionId);
    }

    public void selectAllLocalCollections(Context application) {
        TrackingRoomDatabase db = TrackingRoomDatabase.getDatabase(application);
        CollectionDao collectionDao = db.collectionDao();
        new selectAllLocalCollectionsAsyncTask(collectionDao).execute();
    }

    private static class insertCollectionsAsyncTask extends AsyncTask<List<LocalCollection>, Void, Void> {

        private CollectionDao collectionDao;

        private insertCollectionsAsyncTask(CollectionDao collectionDao) {
            this.collectionDao = collectionDao;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<LocalCollection>... lists) {
            collectionDao.insertCollections(lists[0]);
            return null;
        }
    }

    private static class updateCollectionAsyncTask extends AsyncTask<Integer, Void, Void> {

        private CollectionDao collectionDao;

        private updateCollectionAsyncTask(CollectionDao collectionDao) {
            this.collectionDao = collectionDao;
        }


        @Override
        protected Void doInBackground(Integer... integers) {
            collectionDao.updateCollection(integers[0]);
            return null;
        }
    }

    private class selectAllLocalCollectionsAsyncTask extends AsyncTask<Void, Void, List<LocalCollection>> {

        private CollectionDao collectionDao;

        private selectAllLocalCollectionsAsyncTask(CollectionDao collectionDao) {
            this.collectionDao = collectionDao;
        }

        @Override
        protected void onPostExecute(List<LocalCollection> localCollections) {
            collectionTrackingInterface.onSelectAllLocalCollectionsResponse(localCollections);
            super.onPostExecute(localCollections);
        }

        @Override
        protected List<LocalCollection> doInBackground(Void... voids) {
            return collectionDao.selectAllLocalCollections();
        }
    }

    public interface CollectionTrackingInterface {
        void onSelectAllLocalCollectionsResponse(List<LocalCollection> localCollections);
    }

}
