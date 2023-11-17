package com.example.myhelloapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myhelloapplication.Model.LaunchDetail;
import com.example.myhelloapplication.R;
import com.example.myhelloapplication.Retrofit.ApiClient;
import com.example.myhelloapplication.Retrofit.ApiInterface;
import com.example.myhelloapplication.RoomDB.Repository.LaunchRepository;
import com.example.myhelloapplication.Activity.ViewModel.LaunchViewModel;
import com.example.myhelloapplication.adpater.LaunchesAdapter;
import com.example.myhelloapplication.adpater.LaunchesAdapter.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private LaunchViewModel launchViewModel;

    private RecyclerView recyclerView;
    private ArrayList<LaunchDetail> launchDetailsList;
    private LaunchRepository launchRepository;
    private LaunchesAdapter launchesAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        launchRepository = new LaunchRepository(getApplication());
        recyclerView=findViewById(R.id.idRVLaunches);
        progressBar=findViewById(R.id.idLoading);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        launchViewModel = new ViewModelProvider(this).get(LaunchViewModel.class);

        launchesAdapter = new LaunchesAdapter(getApplicationContext(), launchDetailsList);

        networkRequest();


        launchesAdapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(int position, LaunchDetail launchDetail) {
              Intent intent= new Intent(MainActivity.this,LaunchDetailsActivity.class);

              intent.putExtra("launch_detail", launchDetail);
              startActivity(intent);

            }
        });


    }

    private void networkRequest() {

        ApiInterface apiInterface = new ApiClient().getInstance().create(ApiInterface.class);
        Call<ArrayList<LaunchDetail>> call = apiInterface.getAllLaunches();
        call.enqueue(new Callback<ArrayList<LaunchDetail>>() {
            @Override
            public void onResponse(Call<ArrayList<LaunchDetail>> call, Response<ArrayList<LaunchDetail>> response) {
                if (response.isSuccessful()) {

                    progressBar.setVisibility(View.GONE);
                    Log.d("main", "onResponse: " + response.body().get(0).getMission_date());
                    Log.d("main", "onResponse: " + response.body().get(0));
                    Log.d("main", "onResponse: " + response.body().get(1));

                    launchDetailsList = response.body();
                    launchViewModel.insert(response.body());


                    getLaunches();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<LaunchDetail>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something went wrong...", Toast.LENGTH_SHORT).show();
                Log.e("error", t.getMessage().toString());
            }
        });

    }

    public void getLaunches() {
        launchViewModel.getAllLaunches().observe(this, new Observer<List<LaunchDetail>>() {
            @Override
            public void onChanged(List<LaunchDetail> launchDetailList) {
                recyclerView.setAdapter(launchesAdapter);
                launchesAdapter.getAllLaunches(launchDetailList);

                Log.d("main", "onChanged: " + launchDetailList);
            }
        });

    }



}