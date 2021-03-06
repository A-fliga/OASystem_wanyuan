package org.oasystem_wanyuan.mvp.presenter.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.constants.Constants;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.manager.FirmingTypeManager;
import org.oasystem_wanyuan.manager.UserManager;
import org.oasystem_wanyuan.mvp.model.BaseEntity;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.AllUserBean;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;
import org.oasystem_wanyuan.mvp.model.bean.UserInfo;
import org.oasystem_wanyuan.mvp.presenter.fragment.OfficialFragment;
import org.oasystem_wanyuan.mvp.presenter.fragment.UserCenterFragment;
import org.oasystem_wanyuan.mvp.view.MainDelegate;
import org.oasystem_wanyuan.mvp.view.customView.NoScrollViewPager;
import org.oasystem_wanyuan.utils.AppUtil;
import org.oasystem_wanyuan.utils.DialogUtil;
import org.oasystem_wanyuan.utils.FileUtil;
import org.oasystem_wanyuan.utils.NetUtil;
import org.oasystem_wanyuan.utils.PackageUtils;
import org.oasystem_wanyuan.utils.ToastUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.jessyan.autosize.AutoSize;


public class MainActivity extends ActivityPresenter<MainDelegate> {
    private static final int WRITE_STORAGE_CODE = 1000;
    private static UpdateAsync sAsync;
    public NoScrollViewPager mViewPager;
    private Boolean mCanFinish = false;//按两次退出APP的标志
    private TimerTask mTask;
    private Timer mTimer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkLocationPermission();
    }

    private void checkUpdate() {
        String version = UserManager.getInstance().getUserInfo().getSys_app().getApp_v();
        String[] s = version.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                sb.append(s[i]).append(".");
            } else sb.append(s[i]);
        }
        if (Float.parseFloat(AppUtil.getVersionName()) < Float.parseFloat(sb.toString())) {
            //开始下载更新并安装
            sAsync = new UpdateAsync(new WeakReference<MainActivity>(this));
            sAsync.execute(UserManager.getInstance().getUserInfo().getSys_app().getApp_path());
        }
    }

    @Override
    public Class<MainDelegate> getDelegateClass() {
        return MainDelegate.class;
    }

    public static class UpdateAsync extends AsyncTask<String, Integer, String> {
        private Context context;
        ProgressDialog pd;
        private MainActivity activity;

        public UpdateAsync(WeakReference<MainActivity> weakReference) {
            context = weakReference.get();
            activity = weakReference.get();
        }

        @Override
        protected String doInBackground(String... strings) {
            return downLoadApk(strings[0]);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = DialogUtil.showProgressDialog(context);
            AutoSize.cancelAdapt(activity);
            pd.show();
        }

        public void setMax(final int max) {
            ActivityPresenter.getTopActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    pd.setMax(max);
                }
            });
        }

        public void upDateProgress(final int progress) {
            publishProgress(progress);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();
            if (s.equals("")) {
                ToastUtil.l("更新出现错误");
            } else {
                PackageUtils.install(context, s);
                activity.finish();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            pd.setProgress(values[0]);
        }
    }


    public static String downLoadApk(String appUtl) {
        String apkPath;
        if (NetUtil.isConnectNoToast()) {
            String apkDirPath = Constants.DOWNLOAD_UPDATE;
            File apkDir = new File(apkDirPath);
            if (apkDir.exists()) {
                FileUtil.deleteFile(apkDir);
                apkDir.mkdirs();
            } else {
                apkDir.mkdirs();
            }
            try {
                URL url = new URL(appUtl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if (conn.getResponseCode() == 200) {
                    apkPath = apkDirPath + File.separator + System.currentTimeMillis() + ".apk";
                    File apkFile = new File(apkPath);
                    if (!apkFile.exists()) {
                        apkFile.createNewFile();
                    }
                    InputStream is = url.openStream();
                    OutputStream os = new FileOutputStream(apkPath);
                    sAsync.setMax(conn.getContentLength());
                    byte[] fileByte = new byte[4096];
                    int len;
                    int per = 0;
                    while ((len = is.read(fileByte)) != -1) {
                        os.write(fileByte, 0, len);
                        per += len;
                        sAsync.upDateProgress(per);
                    }
                    is.close();
                    os.close();
                } else return "";
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "";
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
            return apkPath;
        } else return "";
    }

    private void getFirmingType() {
        PublicModel.getInstance().getType(new MSubscribe<BaseEntity<HomeTypeBean>>() {
            @Override
            public void onNext(BaseEntity<HomeTypeBean> bean) {
                super.onNext(bean);
                List<HomeTypeBean.DataBean> beanList = new ArrayList<HomeTypeBean.DataBean>();
                beanList.addAll(bean.getData().getData());
                FirmingTypeManager.getInstance().addBeanList(beanList);
                initTabView();
                checkUpdate();
            }
        });
    }

    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_STORAGE_CODE);
        } else {
            getUserInfo();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_STORAGE_CODE) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                DialogUtil.showDialog(MainActivity.this, "需要打开存储(内存卡)权限才可以正常使用", "去打开", "取消", onClickListener);
            } else {
                getUserInfo();
            }
        }
    }

    private DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                Intent intent = new Intent();
                try {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    // 将用户引导到系统设置页面
                    if (Build.VERSION.SDK_INT >= 9) {
                        Log.e("HLQ_Struggle", "APPLICATION_DETAILS_SETTINGS");
                        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.fromParts("package", getPackageName(), null));
                    } else if (Build.VERSION.SDK_INT <= 8) {
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                        intent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
                    }
                    startActivity(intent);
                    finish();
                } catch (Exception e) {//抛出异常就直接打开设置页面
                    intent = new Intent(Settings.ACTION_SETTINGS);
                    startActivity(intent);
                    finish();
                }
            } else {
                finish();
            }
        }
    };

    public void setCheck(int position) {
        mViewDelegate.setCheck(position);
    }

    private void getUserInfo() {
        PublicModel.getInstance().getUserInfo(new MSubscribe<BaseEntity<UserInfo>>() {
            @Override
            public void onNext(BaseEntity<UserInfo> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    UserManager.getInstance().setUserInfo(bean.getData());
                    getFirmingType();
                    getAllUserInfo();
                }
            }
        });
    }

    private void getAllUserInfo() {
        PublicModel.getInstance().getAllUser(new MSubscribe<BaseEntity<AllUserBean>>() {
            @Override
            public void onNext(BaseEntity<AllUserBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    UserManager.getInstance().setAllUserInfo(bean.getData());
                }
            }
        });
    }

    private void initTabView() {
        mViewPager = mViewDelegate.get(R.id.content_pager);
        mFragmentPagerAdapter mFragmentPagerAdapter = new mFragmentPagerAdapter(getSupportFragmentManager(), getFragments());
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewDelegate.setOnClickListener(mOnclickListener, R.id.home_official_btn, R.id.home_mine_btn);
        setCheck(0);
    }


    private View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.home_official_btn:
                    if (mViewPager != null) {
                        mViewPager.setCurrentItem(0);
                        setCheck(0);
                    }
                    break;
                case R.id.home_mine_btn:
                    if (mViewPager != null) {
                        mViewPager.setCurrentItem(1);
                        setCheck(1);
                    }
                    break;

            }
        }
    };


    public class mFragmentPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> mFragments;

        public mFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> pFragments) {
            super(fm);
            this.mFragments = pFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments == null ? 0 : mFragments.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }


    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new OfficialFragment());
        fragments.add(new UserCenterFragment());
        return fragments;
    }


    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return false;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return doubleClickToQuit(keyCode, event);
    }

    private boolean doubleClickToQuit(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (!mCanFinish) {
                mCanFinish = true;
                ToastUtil.s("再按一次退出");
                mTask = new TimerTask() {
                    @Override
                    public void run() {
                        mCanFinish = false;
                    }
                };
                mTimer.schedule(mTask, 2500);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTask != null) {
            mTask.cancel();
        }
        if (sAsync != null) {
            sAsync.cancel(true);
        }
    }
}
