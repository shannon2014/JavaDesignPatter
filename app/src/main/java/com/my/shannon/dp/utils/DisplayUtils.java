package com.my.shannon.dp.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;
import static android.view.WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;

public class DisplayUtils {
    /**
     * get screen height
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /**
     * get screen width
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static Point getScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2) {
            return new Point(display.getWidth(), display.getHeight());
        } else {
            Point point = new Point();
            display.getSize(point);
            return point;
        }
    }

    /**
     * dp to px
     *
     * @param context
     * @param dpVale
     * @return
     */
    public static int dip2px(Context context, float dpVale) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpVale * scale + 0.5f);
    }

    /**
     * dip to sp
     *
     * @param context
     * @param sp
     * @return
     */
    public static int dip2sp(Context context, float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    /**
     * px to dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * px to sp
     */
    public static int px2sp(Context context, int pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * sp to px
     */
    public static int sp2px(Context context, int spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static void setStatusBar(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else {
            window.addFlags(FLAG_TRANSLUCENT_STATUS);
        }

    }

    /**
     * statusbar color
     *
     * @param color
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarColor(Activity activity, @ColorInt int color) {
        final Window window = activity.getWindow();
        window.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
    }

    /**
     * set translucent
     *
     * @param translucent
     */
    public static void setTranslucentStatusBar(Activity activity, boolean translucent) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (true == translucent) {
            winParams.flags |= FLAG_TRANSLUCENT_STATUS;
        } else {
            winParams.flags &= ~FLAG_TRANSLUCENT_STATUS;
        }
        win.setAttributes(winParams);
    }


    public static boolean isHorizontalScreen(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        int orientation = configuration.orientation;

        return orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static boolean isVerticalScreen(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        int orientation = configuration.orientation;

        return orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
