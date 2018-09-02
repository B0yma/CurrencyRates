package com.boyma.kursvalut.data.site;

import com.boyma.kursvalut.data.site.models.MainSiteJSONobj;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ICurrencyApi {
    @GET("daily_json.js")
    Observable<MainSiteJSONobj> getMainSiteJsonObj();
}
