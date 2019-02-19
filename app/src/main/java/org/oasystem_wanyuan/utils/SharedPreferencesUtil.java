package org.oasystem_wanyuan.utils;

import android.content.Context;
import android.content.SharedPreferences;

import org.oasystem_wanyuan.application.MyApplication;
import org.oasystem_wanyuan.constants.Constants;


import static org.oasystem_wanyuan.constants.Constants.USER_NAME;


/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class SharedPreferencesUtil {
    private static SharedPreferences sharedPreference = null;
    private static SharedPreferences.Editor editor = null;


    /**
     * 保存登录的用户信息
     */
    public static void saveUserStatus(String status) {
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        editor = sharedPreference.edit();
        editor.putString(Constants.LOGIN_TYPE, status);
        editor.apply();
    }

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

    public static String getUserStatus() {
        if (sharedPreference == null) {
            sharedPreference = MyApplication.getContext()
                    .getSharedPreferences(Constants.OA_SYSTEM, Context.MODE_PRIVATE);
        }
        return sharedPreference.getString(Constants.LOGIN_TYPE, null);
    }
}
