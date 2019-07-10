package com.my.shannon.dp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.my.shannon.dp.base.activity.BaseActivity;
import com.my.shannon.dp.business.observepattern.ObserveActivity;
import com.my.shannon.dp.utils.DisplayUtils;
import com.my.shannon.dp.widget.FuncButton;

public class MainActivity extends BaseActivity {
    protected Context mContext;
    protected LinearLayout mLLContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mLLContent = (LinearLayout) findViewById(R.id.ll_content);

        addFunctionBtn(new FuncButton(mContext, "观察者模式", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDemo(ObserveActivity.class);
            }
        }), new FuncButton(mContext, "观察者模式", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDemo(ObserveActivity.class);
            }
        }), new FuncButton(mContext, "观察者模式", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDemo(ObserveActivity.class);
            }
        }));
    }

    private void addFunctionBtn(FuncButton... funcButtons) {
        LinearLayout linearLayout = new LinearLayout(mContext);
        mLLContent.addView(linearLayout);

        int screenWidth = DisplayUtils.getScreenWidth(mContext);
        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(screenWidth / funcButtons.length - 20,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < funcButtons.length; i++) {
            FuncButton btn = funcButtons[i];
            FrameLayout fm = new FrameLayout(mContext);
            fm.setPadding(10, 10, 10, 10);
            fm.addView(btn, lp);
            linearLayout.addView(fm);
        }
    }

    private void startDemo(Class<? extends Activity> activity) {
        try {
            Intent intent = new Intent(mContext, activity);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
