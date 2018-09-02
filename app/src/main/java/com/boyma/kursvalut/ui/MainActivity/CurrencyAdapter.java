package com.boyma.kursvalut.ui.MainActivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.boyma.kursvalut.R;
import com.boyma.kursvalut.data.site.models.SiteCurrencyJSONobj;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class CurrencyAdapter extends ArrayAdapter<SiteCurrencyJSONobj> {


    public CurrencyAdapter(@NonNull Context context, @NonNull List<SiteCurrencyJSONobj> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SiteCurrencyJSONobj currencyJSONobj = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView tl = convertView.findViewById(R.id.tl);
        TextView tr = convertView.findViewById(R.id.tr);
        TextView bl = convertView.findViewById(R.id.bl);
        TextView br = convertView.findViewById(R.id.br);

        bl.setText(currencyJSONobj.getCharCode());
        tr.setText(String.valueOf(currencyJSONobj.getValue()));
        tl.setText(getTLtext(currencyJSONobj.getName(),currencyJSONobj.getNominal()));
        br.setText(getDiff(currencyJSONobj.getValue(),currencyJSONobj.getPrevious()));

        return convertView;
    }

    private String getTLtext(String name, Integer nominal) {
        if (nominal!=1){
            return name +" - x"+String.valueOf(nominal);
        }else {
            return name;
        }
    }

    private String getDiff(Double value, Double previous) {
        double diff = value-previous;
        BigDecimal val = new BigDecimal(String.valueOf(diff));
        String sdiff = val.setScale(3, RoundingMode.HALF_UP).toString();
        if (diff>0) sdiff = "+"+sdiff;
        return sdiff;
    }
}
