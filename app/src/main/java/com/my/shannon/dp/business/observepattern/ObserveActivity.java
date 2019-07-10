package com.my.shannon.dp.business.observepattern;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.my.shannon.dp.R;
import com.my.shannon.dp.base.activity.BaseActivity;
import com.my.shannon.dp.utils.ActivityUtils;

public class ObserveActivity extends BaseActivity {

    ObserveFragment fragment;
    ObservePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe);
        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initUI() {
        fragment = (ObserveFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (null == fragment) {
            fragment = new ObserveFragment();
        }

        presenter = new ObservePresenter(fragment);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.fragment);
    }
}
