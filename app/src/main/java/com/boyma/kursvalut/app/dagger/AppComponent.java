package com.boyma.kursvalut.app.dagger;

import com.boyma.kursvalut.app.ComponentsHolder;
import com.boyma.kursvalut.data.prefs.Preferences;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, AppSubComponentsModule.class})
public interface AppComponent {
    void injectComponentsHolder(ComponentsHolder componentsHolder);
    Preferences getPreferences();
}