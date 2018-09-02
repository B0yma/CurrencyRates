package com.boyma.kursvalut.base;

public interface IMvpPresenter<V extends IMvpView> {
    void attachView(V mvpView);

    void viewIsReady();

    void detachView();

    void destroy();
}
