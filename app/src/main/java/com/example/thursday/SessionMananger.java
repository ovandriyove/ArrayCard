package com.example.thursday;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionMananger {

    public static final String PREF_DAY = "prefDay";
    public static final String PREF_USERNAME = "prefUsername";
    public static final String PREF_EMAIL = "prefEmail";
    public static final String IS_LOGIN = "isLogin";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionMananger(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_DAY, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSharedPrefString (String keySharedPref, String value){
        editor.putString(keySharedPref, value);
        editor.commit();
    }

    public void saveSharedPrefInt (String keySharedPref, int value){
        editor.putInt(keySharedPref, value);
        editor.commit();
    }

    public void saveSharedPrefBoolean (String keySharedPref, boolean value){
        editor.putBoolean(keySharedPref, value);
        editor.commit();
    }

    public String getPrefName() {
        return sharedPreferences.getString(PREF_USERNAME,"");
    }

    public String getPrefEmail() {
        return sharedPreferences.getString(PREF_EMAIL,"");
    }

    public boolean getIsLogin() {
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public void logOutUser() {
        editor.clear();
        editor.commit();
    }
}
