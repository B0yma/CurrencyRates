
package com.boyma.kursvalut.data.site.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainSiteJSONobj {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("PreviousDate")
    @Expose
    private String previousDate;
    @SerializedName("PreviousURL")
    @Expose
    private String previousURL;
    @SerializedName("Timestamp")
    @Expose
    private String timestamp;
    @SerializedName("Valute")
    @Expose
    private Valute valute;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Valute getValute() {
        return valute;
    }

    public void setValute(Valute valute) {
        this.valute = valute;
    }

    public ArrayList<SiteCurrencyJSONobj> getValutes() {
        ArrayList<SiteCurrencyJSONobj> al = new ArrayList<>();
        al.add(this.getValute().getUSD());
        al.add(this.getValute().getEUR());
        al.add(this.getValute().getAUD());
        al.add(this.getValute().getAMD());
        al.add(this.getValute().getBRL());
        al.add(this.getValute().getBYN());
        al.add(this.getValute().getCAD());
        al.add(this.getValute().getCHF());
        al.add(this.getValute().getCNY());
        al.add(this.getValute().getCZK());
        al.add(this.getValute().getDKK());
        al.add(this.getValute().getEUR());
        al.add(this.getValute().getGBP());
        al.add(this.getValute().getHKD());
        al.add(this.getValute().getHUF());
        al.add(this.getValute().getINR());
        al.add(this.getValute().getJPY());
        al.add(this.getValute().getKGS());
        al.add(this.getValute().getKRW());
        al.add(this.getValute().getKZT());
        al.add(this.getValute().getMDL());
        al.add(this.getValute().getNOK());
        al.add(this.getValute().getPLN());
        al.add(this.getValute().getRON());
        al.add(this.getValute().getSEK());
        return al;
    }
}
