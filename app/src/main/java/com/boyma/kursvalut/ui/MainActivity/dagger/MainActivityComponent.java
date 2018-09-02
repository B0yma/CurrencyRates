package com.boyma.kursvalut.ui.MainActivity.dagger;

import com.boyma.kursvalut.base.dagger.ActivityComponent;
import com.boyma.kursvalut.base.dagger.ActivityComponentBuilder;
import com.boyma.kursvalut.ui.MainActivity.MainActivity;

import dagger.Subcomponent;

@MainActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends ActivityComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivityComponent, MainActivityModule> {

    }
}
