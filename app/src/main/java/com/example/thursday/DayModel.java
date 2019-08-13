package com.example.thursday;

public class DayModel {

    private String mName;
    private String mIgn;
    private String mEmail;
    int mPhoto;

    public DayModel(String name, String ign, String email, int photo){
        mName = name;
        mIgn = ign;
        mEmail = email;
        mPhoto = photo;
    }

    public String getmName() {
        return mName;
    }

    public String getmIgn() {
        return mIgn;
    }

    public String getmEmail() {
        return mEmail;
    }

    public int getmPhoto() {
        return mPhoto;
    }
}
