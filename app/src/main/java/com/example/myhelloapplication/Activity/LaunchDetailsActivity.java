package com.example.myhelloapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myhelloapplication.Model.LaunchDetail;
import com.example.myhelloapplication.R;
import com.example.myhelloapplication.RoomDB.Repository.LaunchRepository;

import java.util.List;

public class LaunchDetailsActivity extends AppCompatActivity {

    private TextView txtMissionName;
    private TextView txtLaunchDate;
    private TextView txtRocketName;
    private TextView txtMissionSatus;
    private TextView txtMissionDescription;
    private TextView txtRocketType;
    private TextView txtArticleLink;
    private TextView txtMissionSite;

    private ImageView imgRocketImage;

    private LaunchRepository launchRepository;
    private LaunchDetail launchDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_details2);

        txtMissionName = findViewById(R.id.txtMissionName);
        txtRocketName = findViewById(R.id.txtRocketName);
        txtArticleLink = findViewById(R.id.txtArticleLink);
        txtLaunchDate = findViewById(R.id.txtMissionDate);
        txtMissionDescription = findViewById(R.id.txtMissionDesc);
        txtMissionSite = findViewById(R.id.txtMissionSite);
        txtRocketType = findViewById(R.id.txtRocketType);
        txtMissionSatus = findViewById(R.id.txtMissionStatus);
        imgRocketImage= findViewById(R.id.imgLaunchImage);

        launchRepository=new LaunchRepository(getApplication());

        if (getIntent().hasExtra("launch_detail")) {
            launchDetail = getIntent().getParcelableExtra("launch_detail");

            Log.e("launch ", launchDetail.toString());
        }
        if (launchDetail != null) {
            Log.e("launch details" ,launchDetail.toString());
            txtMissionName.setText(launchDetail.getMission_name());
            txtRocketName.setText(launchDetail.getRocket().getRocket_name());
            txtRocketType.setText(launchDetail.getRocket().getRocket_type());
            txtLaunchDate.setText(launchDetail.getMission_date());
            txtMissionDescription.setText(launchDetail.getDetails());
            txtMissionSite.setText(launchDetail.getLaunch_site().getSite_name_long());
            txtArticleLink.setText(launchDetail.getLinks().getArticle_link());

            if(launchDetail.getUpcoming()==false){
                if(launchDetail.getLaunch_success()==true){
                    txtMissionSatus.setText("Successful");
                }else {
                    txtMissionSatus.setText("Failed");

                }
            }
            else {
                txtMissionSatus.setText("Upcoming");

            }

            Glide.with(this)
                    .load(launchDetail.getLinks().getMission_patch())
                    .into(imgRocketImage);


        }

    }
}