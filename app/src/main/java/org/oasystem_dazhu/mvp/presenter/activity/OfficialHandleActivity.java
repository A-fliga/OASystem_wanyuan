package org.oasystem_dazhu.mvp.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.greenrobot.eventbus.EventBus;
import org.oasystem_dazhu.R;
import org.oasystem_dazhu.mvp.model.bean.ScreenBean;
import org.oasystem_dazhu.mvp.presenter.fragment.OfficialListFragment;
import org.oasystem_dazhu.mvp.view.OfficialHandleDelegate;
import org.oasystem_dazhu.mvp.view.customView.NoScrollViewPager;

import java.util.ArrayList;

/**
 * Created by www on 2019/1/19.
 */

public class OfficialHandleActivity extends ActivityPresenter<OfficialHandleDelegate> {
    private int typeId;
    private NoScrollViewPager viewPager;
    private Boolean done = false;
    private OfficialListFragment notDoneFragment, doneFragment;
    private Boolean isPositive = false;

    @Override
    public Class<OfficialHandleDelegate> getDelegateClass() {
        return OfficialHandleDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        typeId = getIntent().getExtras().getInt("typeId");
        viewDelegate.initViews(typeId);
        initViewPager();
        viewDelegate.setOnClickListener(onClickListener, R.id.official_not_done_tab, R.id.official_done_tab, R.id.to_screen, R.id.to_sort,R.id.refresh);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.official_not_done_tab:
                    if (done) {
                        done = false;
                        changeTopStyle(false);
                        if (viewPager != null)
                            viewPager.setCurrentItem(0);
                    }
                    break;
                case R.id.official_done_tab:
                    if (!done) {
                        done = true;
                        changeTopStyle(true);
                        if (viewPager != null)
                            viewPager.setCurrentItem(1);
                    }
                    break;
                case R.id.to_screen:
                    Intent intent = new Intent(OfficialHandleActivity.this, ScreenActivity.class);
                    startActivityForResult(intent, 1001);
                    break;
                case R.id.to_sort:
                    isPositive = !isPositive;
                    doneFragment.notifyDataSetChanged(true, isPositive);
                    notDoneFragment.notifyDataSetChanged(false, isPositive);
                    break;

                case R.id.refresh:
                    EventBus.getDefault().post("upLoadSuccess");
                    break;
            }
        }
    };

    private void changeTopStyle(Boolean done) {
//            viewDelegate.get(R.id.official_not_done).setBackground();
//            viewDelegate.get(R.id.official_not_done).setBackground();
        ImageView tv1 = viewDelegate.get(R.id.official_not_done_tab);
        tv1.setImageResource(done ? R.mipmap.not_read_normal : R.mipmap.not_read_selected);
        ImageView tv2 = viewDelegate.get(R.id.official_done_tab);
        tv2.setImageResource(done ? R.mipmap.read_selected : R.mipmap.read_normal);
    }

    private void initViewPager() {
        viewPager = viewDelegate.getViewPager();
//        viewPager.setOffscreenPageLimit(1);
        mFragmentPagerAdapter mFragmentPagerAdapter = new mFragmentPagerAdapter(getSupportFragmentManager(), getFragments());
        viewPager.setAdapter(mFragmentPagerAdapter);
    }

    private ArrayList<OfficialListFragment> getFragments() {
        Bundle bundle = new Bundle();
        ArrayList<OfficialListFragment> fragments = new ArrayList<>();
        notDoneFragment = new OfficialListFragment();
        bundle.putBoolean("done", false);
        bundle.putInt("typeId", typeId);
        notDoneFragment.setArguments(bundle);
        doneFragment = new OfficialListFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putBoolean("done", true);
        bundle1.putInt("typeId", typeId);
        doneFragment.setArguments(bundle1);
        fragments.add(notDoneFragment);
        fragments.add(doneFragment);
        return fragments;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 2000) {
            ScreenBean screenBean = (ScreenBean) data.getExtras().getSerializable("screenBean");
            if (screenBean != null) {
                screenBean.setType(typeId);
                if (doneFragment != null)
                    doneFragment.getDoneDocument(screenBean);
                if (notDoneFragment != null)
                    notDoneFragment.getNotDoneDocument(screenBean);
            }
        }
    }

    public class mFragmentPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<OfficialListFragment> mFragments;

        public mFragmentPagerAdapter(FragmentManager fm, ArrayList<OfficialListFragment> pFragments) {
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

}
