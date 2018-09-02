package com.boyma.kursvalut.base;

public abstract class PresenterBase<T extends IMvpView> implements IMvpPresenter<T>  {
    private T view;

    @Override
    public void attachView(T mvpView) {
        view = mvpView;
        System.out.println("attachView()");
    }

    @Override
    public void detachView() {
        view = null;
        System.out.println("detachView()");
    }

    public T getView() {
        return view;
    }

    protected boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
