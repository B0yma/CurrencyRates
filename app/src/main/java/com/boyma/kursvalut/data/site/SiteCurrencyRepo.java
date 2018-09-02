package com.boyma.kursvalut.data.site;

import com.boyma.kursvalut.data.site.models.MainSiteJSONobj;


import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SiteCurrencyRepo {
    public Observable getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ICurrencyApi iCurrencyApi = retrofit.create(ICurrencyApi.class);

        Observable<MainSiteJSONobj> currencies = iCurrencyApi.getMainSiteJsonObj();
        return currencies;
    }
}
