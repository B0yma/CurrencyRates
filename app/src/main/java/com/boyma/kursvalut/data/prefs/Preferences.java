package com.boyma.kursvalut.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    final static String FILE_NAME = "preferences";

    final static String param = "myparam";

    private SharedPreferences preferences;

    public Preferences(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, 0);
    }

    private SharedPreferences.Editor getEditor() {
        return preferences.edit();
    }

    public void setParam(String data) {
        getEditor().putString(param, data).commit();
    }

    public String getParam() {
        return preferences.getString(param, "");
    }
}
