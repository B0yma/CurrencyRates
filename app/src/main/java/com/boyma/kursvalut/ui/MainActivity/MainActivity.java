package com.boyma.kursvalut.ui.MainActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.boyma.kursvalut.R;
import com.boyma.kursvalut.app.App;
import com.boyma.kursvalut.common.Constants;
import com.boyma.kursvalut.data.site.models.SiteCurrencyJSONobj;
import com.boyma.kursvalut.ui.MainActivity.dagger.MainActivityModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainActivityContr.View {

    private ProgressDialog progress;
    private ListView listView;
    private TextView logtv;

    @Inject
    IMainActivityContr.Presenter mpresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initUI();

        //extract mode
        Constants.MainActivityMode mainMode = (Constants.MainActivityMode)
                getIntent().getSerializableExtra(Constants.MODE);

        // inject activity
        App.getApp(this)
                .getComponentsHolder()
                .getActivityComponent(getClass(), new MainActivityModule(mainMode))
                .inject(this);

        mpresenter.attachView(this);


        //mpresenter.loadCurrencyListView();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresenter.detachView(listView.onSaveInstanceState());
        if (isFinishing()) {
            mpresenter.destroy();
            App.getApp(this).getComponentsHolder().releaseActivityComponent(getClass());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mpresenter.onResume();

    }

    private void initUI() {
        listView = findViewById(R.id.list_view);
        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            mpresenter.onClickFAB();
        });
        logtv = findViewById(R.id.logtv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showLoadingDialog() {
        progress = new ProgressDialog(this);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setTitle("Загрузка");
        progress.setMessage("Подождите...");
        progress.setCancelable(false);
        progress.show();
    }

    @Override
    public void hideLoadingDialog() {
        progress.dismiss();
    }

    @Override
    public void updateCurrencyListView(List<SiteCurrencyJSONobj> currenciesData) {
        CurrencyAdapter currencyAdapter = new CurrencyAdapter(getApplicationContext(),currenciesData);
        listView.setAdapter(currencyAdapter);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean getOnlineStatus() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    @Override
    public void hideLogTextView() {
        logtv.setVisibility(View.GONE);
    }

    @Override
    public void loadListState(Parcelable listState) {
        listView.onRestoreInstanceState(listState);
    }


    public static void showDefaultModeActivity(Context context) {
        startActivity(context, Constants.MainActivityMode.DEFAULT);
    }

    private static void startActivity(Context context, Constants.MainActivityMode pinCodeMode) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Constants.MODE, pinCodeMode);
        context.startActivity(intent);
    }
}
