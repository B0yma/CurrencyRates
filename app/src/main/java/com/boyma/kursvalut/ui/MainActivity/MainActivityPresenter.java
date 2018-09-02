package com.boyma.kursvalut.ui.MainActivity;

import android.os.Parcelable;

import com.boyma.kursvalut.base.PresenterBase;
import com.boyma.kursvalut.data.site.SiteCurrencyRepo;
import com.boyma.kursvalut.data.site.models.MainSiteJSONobj;
import com.boyma.kursvalut.data.site.models.SiteCurrencyJSONobj;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter extends PresenterBase<IMainActivityContr.View> implements IMainActivityContr.Presenter {
    private SiteCurrencyRepo siteCurrencyRepo;
    private List<SiteCurrencyJSONobj> currencies;
    private Parcelable listState;
    private boolean loadstate = false;

    public MainActivityPresenter() {
        siteCurrencyRepo = new SiteCurrencyRepo();
    }

    @Override
    public void onClickFAB() {
        if (getView().getOnlineStatus()) {
            loadCurrencyListView();
        }else {
            getView().showToast("No connection");
        }
    }

    @Override
    public void loadCurrencyListView() {
        getView().showLoadingDialog();
        loadstate = true;
        Observable<MainSiteJSONobj> dataObservable = siteCurrencyRepo.getData();
        dataObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(1,TimeUnit.MILLISECONDS,AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<MainSiteJSONobj>() {
                    @Override
                    public void onNext(MainSiteJSONobj mainSiteJSONobj) {

                        currencies = new ArrayList<>();
                        currencies.addAll(mainSiteJSONobj.getValutes());

                        loadstate = false;

                        getView().updateCurrencyListView(currencies);
                        getView().hideLogTextView();
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadstate = false;
                        getView().showToast(e.toString());
                        getView().hideLoadingDialog();
                    }

                    @Override
                    public void onComplete() {
                        getView().hideLoadingDialog();
                    }
                });

    }

    @Override
    public void onResume() {
        if (currencies!=null){
            getView().updateCurrencyListView(currencies);
            getView().loadListState(listState);
            getView().hideLogTextView();
        }
        if (loadstate){
            getView().showLoadingDialog();
        }
    }

    @Override
    public void detachView(Parcelable state) {
        listState = state;
    }


    @Override
    public void viewIsReady() {

    }

}
