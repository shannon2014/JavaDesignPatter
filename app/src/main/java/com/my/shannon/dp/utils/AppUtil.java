package com.my.shannon.dp.utils;

import android.content.Context;

public class AppUtil {
    private static Context mApplicationContext;


    public static void init(Context context) {
        mApplicationContext = context.getApplicationContext();
    }

    public static Context getContext() {
        return mApplicationContext;
    }
}
