package com.example.myhelloapplication.Model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class LaunchSite implements Parcelable {

    private String site_name_long;

    protected LaunchSite(Parcel in) {
        site_name_long = in.readString();
    }

    public static final Creator<LaunchSite> CREATOR = new Creator<LaunchSite>() {
        @Override
        public LaunchSite createFromParcel(Parcel in) {
            return new LaunchSite(in);
        }

        @Override
        public LaunchSite[] newArray(int size) {
            return new LaunchSite[size];
        }
    };

    public String getSite_name_long() {
        return site_name_long;
    }

    public void setSite_name_long(String site_name_long) {
        this.site_name_long = site_name_long;
    }

    public LaunchSite(String site_name_long) {
        this.site_name_long = site_name_long;
    }

    @Override
    public String toString() {
        return "LaunchSite{" +
                "site_name_long='" + site_name_long + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(site_name_long);
    }
}
