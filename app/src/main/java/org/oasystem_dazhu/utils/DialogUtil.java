package org.oasystem_dazhu.utils;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import org.oasystem_dazhu.R;


/**
 * Created by www on 2017/11/16.
 */

public class DialogUtil {
    /**
     * 这是兼容的 AlertDialog
     */
    public static void showDialog(Context context, String message, String sure,
                                  String cancel, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("温馨提示").setCancelable(false).setPositiveButton(sure, listener).
                setNegativeButton(cancel, listener).setMessage(message).show();
    }

    /**
     * 复选对话框
     */
    public static void showChoiceDialog(Context context, String sure,
                                        String cancel,String[] data, boolean[] booleanList,
                                        DialogInterface.OnClickListener listener,
                                        DialogInterface.OnMultiChoiceClickListener multiChoiceClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("请选择人员").setCancelable(false).setPositiveButton(sure, listener).
                setNegativeButton(cancel, listener).setMultiChoiceItems(data,booleanList,multiChoiceClickListener).show();
    }

    public static ProgressDialog showProgressDialog(Context context) {
        ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("正在更新，请勿关闭！");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setCanceledOnTouchOutside(false);
        pd.setCancelable(false);
        pd.setProgress(0);
        return pd;
    }

    public static AlertDialog createAlertDialog(Context context, View view) {
        AlertDialog dialog = new AlertDialog.Builder(context).setCancelable(false).create();
        dialog.setView(view);
        return dialog;
    }

    public static View getDialogView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView;
        dialogView = inflater.inflate(R.layout.personal_icon_dialog, null);
        return dialogView;
    }



    /**
     * 这是兼容的 AlertDialog
     */
    public static void showDialog(Context context, String message, String sure, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("温馨提示").setCancelable(false).setPositiveButton(sure, listener).
                setMessage(message).show();
    }

    /**
     * 这是兼容的 AlertDialog
     */
    public static AlertDialog showDialog2(Context context, String message, String sure, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("温馨提示").setCancelable(false).setPositiveButton(sure, listener).
                setMessage(message);
        return builder.show();
    }


    /**
     * 显示定位服务未开启确认对话框
     */
    public static void showLocServiceDialog(final Context context) {
        new AlertDialog.Builder(context).setTitle("手机未开启位置服务")
                .setMessage("请在权限管理里打开")
                .setNegativeButton("取消", null)
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            context.startActivity(intent);
                        } catch (ActivityNotFoundException ex) {
                            intent.setAction(Settings.ACTION_SETTINGS);
                            try {
                                context.startActivity(intent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                })
                .show();
    }


}