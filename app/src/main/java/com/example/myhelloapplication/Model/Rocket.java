package com.example.myhelloapplication.Model;



import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;

import com.google.gson.annotations.SerializedName;

public class Rocket implements Parcelable {

    private String rocket_name;

    private String rocket_type;

    protected Rocket(Parcel in) {
        rocket_name = in.readString();
        rocket_type = in.readString();
    }

    public static final Creator<Rocket> CREATOR = new Creator<Rocket>() {
        @Override
        public Rocket createFromParcel(Parcel in) {
            return new Rocket(in);
        }

        @Override
        public Rocket[] newArray(int size) {
            return new Rocket[size];
        }
    };

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }


    public Rocket(String rocket_name, String rocket_type) {
        this.rocket_name = rocket_name;
        this.rocket_type = rocket_type;
    }

    public String getRocket_type() {
        return rocket_type;
    }

    public void setRocket_type(String rocket_type) {
        this.rocket_type = rocket_type;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "rocket_name='" + rocket_name + '\'' +
                ", rocket_type='" + rocket_type + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(rocket_name);
        parcel.writeString(rocket_type);
    }
}
