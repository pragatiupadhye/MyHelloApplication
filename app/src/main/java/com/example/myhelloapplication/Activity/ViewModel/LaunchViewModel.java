package com.example.myhelloapplication.Activity.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myhelloapplication.Model.LaunchDetail;
import com.example.myhelloapplication.RoomDB.Repository.LaunchRepository;
import java.util.ArrayList;
import java.util.List;

public class LaunchViewModel extends AndroidViewModel {

    private LaunchRepository launchRepository;
    private LiveData<List<LaunchDetail>> getAllLaunches;

    public LaunchViewModel(@NonNull Application application) {
        super(application);
        launchRepository=new LaunchRepository(application);
        getAllLaunches=launchRepository.getAllLaunches();

    }

    public void insert(ArrayList<LaunchDetail> list)
    {
        launchRepository.insert(list);

    }

    public LiveData<List<LaunchDetail>> getAllLaunches()
    {

        return getAllLaunches;
    }
}
