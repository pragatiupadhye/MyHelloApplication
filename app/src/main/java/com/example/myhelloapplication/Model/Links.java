package com.example.myhelloapplication.Model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Links implements Parcelable {

    private String mission_patch;

    private String article_link;

    protected Links(Parcel in) {
        mission_patch = in.readString();
        article_link = in.readString();
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    public String getMission_patch() {
        return mission_patch;
    }

    public void setMission_patch(String mission_patch) {
        this.mission_patch = mission_patch;
    }

    public String getArticle_link() {
        return article_link;
    }

    public void setArticle_link(String article_link) {
        this.article_link = article_link;
    }

    public Links(String mission_patch, String article_link) {
        this.mission_patch = mission_patch;
        this.article_link = article_link;
    }

    @Override
    public String toString() {
        return "Links{" +
                "mission_patch='" + mission_patch + '\'' +
                ", article_link='" + article_link + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(mission_patch);
        parcel.writeString(article_link);
    }
}
