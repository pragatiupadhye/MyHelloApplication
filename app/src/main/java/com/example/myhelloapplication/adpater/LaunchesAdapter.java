package com.example.myhelloapplication.adpater;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myhelloapplication.Model.LaunchDetail;
import com.example.myhelloapplication.R;

import java.util.ArrayList;
import java.util.List;

public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.RecyclerViewHolder> {

    // creating a variable for our array list and context.
    private List<LaunchDetail> launchDetailsArrayList;
    private Context mcontext;
    private OnClickListener onClickListener;


    // creating a constructor class.
    public LaunchesAdapter(Context mcontext,ArrayList<LaunchDetail> recyclerDataArrayList) {
        this.launchDetailsArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_launch_adpater, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview from our modal class.
        LaunchDetail launchDetail = launchDetailsArrayList.get(position);
        holder.launchName.setText(launchDetail.getMission_name());
        holder.rocketName.setText(launchDetail.getRocket().getRocket_name());
        holder.missionDate.setText(launchDetail.getMission_date());
        holder.missionSuccess.setText(launchDetail.getLaunch_success().toString());
        holder.missionUpcoming.setText(launchDetail.getUpcoming().toString());

        Glide.with(mcontext)
                .load(launchDetail.getLinks().getMission_patch())
                .into(holder.launchImage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(position, launchDetail);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        Log.e("size-----------", String.valueOf(launchDetailsArrayList.size()));
        return launchDetailsArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView launchName, rocketName, missionDate,missionSuccess,missionUpcoming;
        private ImageView launchImage;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            launchName = itemView.findViewById(R.id.idLaunchName);
            rocketName = itemView.findViewById(R.id.idRocketName);
            missionDate = itemView.findViewById(R.id.idMissionDate);
            missionSuccess = itemView.findViewById(R.id.idMissionSuccess);
            missionUpcoming = itemView.findViewById(R.id.idMissionUpcoming);
            launchImage = itemView.findViewById(R.id.idLaunchImg);


        }
    }

    public void getAllLaunches(List<LaunchDetail> launchList)
    {
        this.launchDetailsArrayList=launchList;
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position,  LaunchDetail launchDetail);
    }
}