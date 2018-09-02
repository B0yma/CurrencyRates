package com.boyma.kursvalut.app.dagger;

import com.boyma.kursvalut.base.dagger.ActivityComponentBuilder;
import com.boyma.kursvalut.ui.MainActivity.MainActivity;
import com.boyma.kursvalut.ui.MainActivity.dagger.MainActivityComponent;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivityComponent.class})
public class AppSubComponentsModule {

    @Provides
    @IntoMap
    @ClassKey(MainActivity.class)
    ActivityComponentBuilder provideSplashViewBuilder(MainActivityComponent.Builder builder) {
        return builder;
    }

}