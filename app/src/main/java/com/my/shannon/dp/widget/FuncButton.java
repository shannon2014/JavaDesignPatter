package com.my.shannon.dp.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

/**
 * 功能button
 */

public class FuncButton extends AppCompatButton {

    public FuncButton(Context context, String btnName, OnClickListener listener) {
        super(context);
        this.setText(btnName);
        this.setTextSize(18);
        this.setOnClickListener(listener);
    }

}
