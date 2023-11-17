package com.example.myhelloapplication.Model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "launch_detail",indices = {@Index(value = {"flight_number"},
        unique = true)})
public class LaunchDetail implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int missionId;

    @SerializedName("flight_number")
    @ColumnInfo(name = "flight_number")
    private int flight_number;


    @SerializedName("mission_name")
    @ColumnInfo(name = "mission_name")
    private String mission_name;

    @SerializedName("launch_date_local")
    @ColumnInfo(name = "launch_date")
    private String mission_date;

    @SerializedName("launch_success")
    @ColumnInfo(name = "launch_success")
    private Boolean launch_success;

    @SerializedName("upcoming")
    @ColumnInfo(name = "upcoming")
    private Boolean upcoming;

    @SerializedName("details")
    @ColumnInfo(name = "details")
    private String details;

    @Embedded
    private LaunchSite launch_site;

    @Embedded
    private Rocket rocket;

    protected LaunchDetail(Parcel in) {
        missionId = in.readInt();
        mission_name = in.readString();
        mission_date = in.readString();
        byte tmpLaunch_success = in.readByte();
        launch_success = tmpLaunch_success == 0 ? null : tmpLaunch_success == 1;
        byte tmpUpcoming = in.readByte();
        upcoming = tmpUpcoming == 0 ? null : tmpUpcoming == 1;
        details = in.readString();
        rocket = (Rocket) in.readParcelable(Rocket.class.getClassLoader());
        links = (Links) in.readParcelable(Links.class.getClassLoader());
        launch_site = (LaunchSite) in.readParcelable(LaunchSite.class.getClassLoader());

    }

    public static final Creator<LaunchDetail> CREATOR = new Creator<LaunchDetail>() {
        @Override
        public LaunchDetail createFromParcel(Parcel in) {
            return new LaunchDetail(in);
        }

        @Override
        public LaunchDetail[] newArray(int size) {
            return new LaunchDetail[size];
        }
    };

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Embedded
    private Links links;

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String getMission_date() {
        return mission_date;
    }

    public void setMission_date(String mission_date) {
        this.mission_date = mission_date;
    }

    public Boolean getLaunch_success() {
        return launch_success;
    }

    public void setLaunch_success(Boolean launch_success) {
        this.launch_success = launch_success;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LaunchSite getLaunch_site() {
        return launch_site;
    }

    public void setLaunch_site(LaunchSite launch_site) {
        this.launch_site = launch_site;
    }

    public LaunchDetail(int missionId, String mission_name, String mission_date, Boolean launch_success, Boolean upcoming, String details, LaunchSite launch_site, Rocket rocket, Links links) {
        this.missionId = missionId;
        this.mission_name = mission_name;
        this.mission_date = mission_date;
        this.launch_success = launch_success;
        this.upcoming = upcoming;
        this.details = details;
        this.launch_site = launch_site;
        this.rocket = rocket;
        this.links = links;
    }

    @Override
    public String toString() {
        return "LaunchDetail{" +
                "missionId=" + missionId +
                ", mission_name='" + mission_name + '\'' +
                ", mission_date='" + mission_date + '\'' +
                ", launch_success=" + launch_success +
                ", upcoming=" + upcoming +
                ", details='" + details + '\'' +
                ", launch_site=" + launch_site +
                ", rocket=" + rocket +
                ", links=" + links +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(missionId);
        parcel.writeString(mission_name);
        parcel.writeString(mission_date);
        parcel.writeByte((byte) (launch_success == null ? 0 : launch_success ? 1 : 2));
        parcel.writeByte((byte) (upcoming == null ? 0 : upcoming ? 1 : 2));
        parcel.writeString(details);
        parcel.writeParcelable(rocket, i);
        parcel.writeParcelable(links, i);
        parcel.writeParcelable(launch_site, i);



    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }
}


