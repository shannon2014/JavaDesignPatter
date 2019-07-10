package com.my.shannon.dp.utils;

import android.widget.Toast;

public class ToastUtil {
    public static Toast mToast = null;

    public static void showLong(String text) {
        show(text, Toast.LENGTH_LONG);
    }

    public static void show(String text) {
        show(text, Toast.LENGTH_SHORT);
    }

    private static void show(String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(AppUtil.getContext(), text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
