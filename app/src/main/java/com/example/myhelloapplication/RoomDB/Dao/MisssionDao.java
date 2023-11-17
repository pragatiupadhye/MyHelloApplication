package com.example.myhelloapplication.RoomDB.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myhelloapplication.Model.LaunchDetail;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MisssionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ArrayList<LaunchDetail> launchList);

    @Query("SELECT * FROM launch_detail")
    LiveData<List<LaunchDetail>> getAllLaunches();

    @Query("DELETE FROM launch_detail")
    void deleteAll();

    @Query("SELECT * FROM launch_detail where missionId= :missionId")
    LiveData<LaunchDetail> getSingleLaunch(int missionId);



}

