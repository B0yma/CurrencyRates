package com.boyma.kursvalut.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.boyma.kursvalut.app.App;
import com.boyma.kursvalut.data.prefs.Preferences;
import com.boyma.kursvalut.ui.MainActivity.MainActivity;


public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Preferences preferences = App.getApp(this).getComponentsHolder().getAppComponent().getPreferences();

        String param = preferences.getParam();
        /*
        // check myparam
        if (TextUtils.isEmpty(pin)) {
            MainActivity.showFirstModeActivity(this);
        } else {
            MainActivity.showSecondModeActivity(this);
        }*/

        MainActivity.showDefaultModeActivity(this);

        finish();
    }
}
