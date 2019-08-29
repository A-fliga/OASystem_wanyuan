package org.oasystem_wanyuan.utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.oasystem_wanyuan.application.MyApplication;
import org.oasystem_wanyuan.constants.Constants;
import org.oasystem_wanyuan.mvp.view.SignView.PenColor;
import org.oasystem_wanyuan.mvp.view.SignView.PenWidth;


import static org.oasystem_wanyuan.constants.Constants.PEN_COLOR;
import static org.oasystem_wanyuan.constants.Constants.PEN_WIDTH;
import static org.oasystem_wanyuan.constants.Constants.USER_NAME;


/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class SharedPreferencesUtil {
    private static SharedPreferences sharedPreference = null;
    private static SharedPreferences.Editor editor = null;

    /**
     * 保存用户上次登录的用户名
     *
     * @return
     */
    public static void saveUserName(String username) {
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        editor = sharedPreference.edit();
        editor.putString(USER_NAME, username);
        editor.apply();
    }


    public static void savePenWidth(Float width){
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        editor = sharedPreference.edit();
        editor.putFloat(PEN_WIDTH, width);
        editor.apply();
    }

    public static void savePenColor(int color){
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        editor = sharedPreference.edit();
        editor.putInt(PEN_COLOR, color);
        editor.apply();
    }

    public static float getWidth(){
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        return sharedPreference.getFloat(PEN_WIDTH, PenWidth.DEFAULT.getWidth());
    }

    public static int getColor(){
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        return sharedPreference.getInt(PEN_COLOR, PenColor.BLACK.getColor());
    }


    /**
     * 取出用户上次登录的用户名
     *
     * @return
     */
    public static String getUserName() {
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        return sharedPreference.getString(USER_NAME, null);
    }

}
