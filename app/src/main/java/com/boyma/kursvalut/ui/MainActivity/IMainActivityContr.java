package com.boyma.kursvalut.ui.MainActivity;

import android.os.Parcelable;

import com.boyma.kursvalut.base.IMvpPresenter;
import com.boyma.kursvalut.base.IMvpView;
import com.boyma.kursvalut.data.site.models.SiteCurrencyJSONobj;

import java.util.List;

public interface IMainActivityContr {
    interface View extends IMvpView {

        void showLoadingDialog();

        void hideLoadingDialog();

        void updateCurrencyListView(List<SiteCurrencyJSONobj> data);

        void showToast(String s);

        boolean getOnlineStatus();

        void hideLogTextView();

        void loadListState(Parcelable listState);
    }
    interface Presenter extends IMvpPresenter<View> {

        void onClickFAB();

        void loadCurrencyListView();

        void onResume();

        void detachView(Parcelable parcelable);
    }
}
