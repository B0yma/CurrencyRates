package com.boyma.kursvalut.ui.MainActivity.dagger;

import com.boyma.kursvalut.base.dagger.ActivityModule;
import com.boyma.kursvalut.common.Constants;
import com.boyma.kursvalut.ui.MainActivity.IMainActivityContr;
import com.boyma.kursvalut.ui.MainActivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule implements ActivityModule {


    private final Constants.MainActivityMode mainMode;

    public MainActivityModule(Constants.MainActivityMode mainMode) {
        this.mainMode = mainMode;
    }

    @MainActivityScope
    @Provides
    IMainActivityContr.Presenter provideMainActivityPresenter() {
        //modes
        return new MainActivityPresenter();
    }
}
