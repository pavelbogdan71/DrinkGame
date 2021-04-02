package com.example.drinkgame.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    private String name;
    private int shots;


    public void addShot()
    {
        shots++;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
        this.shots = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getShots() {
        return shots;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(shots);
    }
    protected Player(Parcel in) {
        name = in.readString();
        shots = in.readInt();
    }
    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}
