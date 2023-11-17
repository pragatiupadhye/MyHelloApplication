package com.example.myhelloapplication.RoomDB.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.myhelloapplication.Model.LaunchDetail;
import com.example.myhelloapplication.RoomDB.MissionDatabase;
import com.example.myhelloapplication.RoomDB.Dao.MisssionDao;

import java.util.ArrayList;
import java.util.List;

public class LaunchRepository {

    private MissionDatabase database;
    private LiveData<List<LaunchDetail>> getAllLaunches;
    private LiveData<LaunchDetail> getSingleLaunch;

    public LaunchRepository(Application application)
    {
        database=MissionDatabase.getInstance(application);
        getAllLaunches=database.misssionDao().getAllLaunches();

    }

    public void insert(ArrayList<LaunchDetail> launchList){
        new InsertAsynTask(database).execute(launchList);


    }

    public LiveData<List<LaunchDetail>> getAllLaunches()
    {
        return getAllLaunches;
    }

    public LiveData<LaunchDetail> getSingleLaunch(int missionId)
    {
        return database.misssionDao().getSingleLaunch(missionId);
    }

    static class InsertAsynTask extends AsyncTask<ArrayList<LaunchDetail>,Void,Void> {
        private MisssionDao misssionDao;
        InsertAsynTask(MissionDatabase missionDatabase)
        {
            misssionDao=missionDatabase.misssionDao();
        }
        @Override
        protected Void doInBackground(ArrayList<LaunchDetail>... lists) {
            misssionDao.insert(lists[0]);
            return null;
        }
    }
}
