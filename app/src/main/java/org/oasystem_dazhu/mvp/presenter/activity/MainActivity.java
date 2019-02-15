package org.oasystem_dazhu.mvp.presenter.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.ViewGroup;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.http.MSubscribe;
import org.oasystem_dazhu.manager.UserManager;
import org.oasystem_dazhu.mvp.model.BaseEntity;
import org.oasystem_dazhu.mvp.model.PublicModel;
import org.oasystem_dazhu.mvp.model.bean.UserInfo;
import org.oasystem_dazhu.mvp.presenter.fragment.OfficialFragment;
import org.oasystem_dazhu.mvp.presenter.fragment.UserCenterFragment;
import org.oasystem_dazhu.mvp.view.MainDelegate;
import org.oasystem_dazhu.mvp.view.customView.NoScrollViewPager;
import org.oasystem_dazhu.utils.ToastUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActivityPresenter {
    private NoScrollViewPager viewPager;
    private final int WRITE_STORAGE_CODE = 1000;
    private Boolean canFinish = false;//按两次退出APP的标志
    private TimerTask task;
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getUserInfo();
        checkLocationPermission();
    }

    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_STORAGE_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WRITE_STORAGE_CODE) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                ToastUtil.l("请打开内存卡读写权限");
            }
        }
    }


    private void getUserInfo() {
        PublicModel.getInstance().getUserInfo(new MSubscribe<BaseEntity<UserInfo>>() {
            @Override
            public void onNext(BaseEntity<UserInfo> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    UserManager.getInstance().setUserInfo(bean.getData());
                    initTabView();
                }
            }
        });
    }

    private void initTabView() {
        viewPager = viewDelegate.get(R.id.content_pager);
        mFragmentPagerAdapter mFragmentPagerAdapter = new mFragmentPagerAdapter(getSupportFragmentManager(), getFragments());
        viewPager.setAdapter(mFragmentPagerAdapter);
        BottomNavigationView navigation = viewDelegate.get(R.id.navigation);
        navigation.inflateMenu(R.menu.navigation_btn);
        disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //反射取消BottomNavigationView的Item大于3个时的动画效果
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
    }


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


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_official:
                    if (viewPager == null)
                        return false;
                    else {
                        viewPager.setCurrentItem(0);
                        return true;
                    }
                case R.id.navigation_user_center:
                    if (viewPager == null)
                        return false;
                    else {
                        viewPager.setCurrentItem(1);
                        return true;
                    }
            }
            return false;
        }
    };


    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return false;
    }

    @Override
    public Class getDelegateClass() {
        return MainDelegate.class;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return doubleClickToQuit(keyCode, event);
    }

    private boolean doubleClickToQuit(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (!canFinish) {
                canFinish = true;
                ToastUtil.s("再按一次退出");
                task = new TimerTask() {
                    @Override
                    public void run() {
                        canFinish = false;
                    }
                };
                timer.schedule(task, 2500);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (task != null) {
            task.cancel();
        }
    }
}
