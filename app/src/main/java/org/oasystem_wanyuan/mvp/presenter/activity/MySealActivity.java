package org.oasystem_wanyuan.mvp.presenter.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.manager.UserManager;
import org.oasystem_wanyuan.mvp.adapter.MySealAdapter;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.UserInfo;
import org.oasystem_wanyuan.mvp.view.MySealDelegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;

/**
 * Created by www on 2019/1/5.
 */

public class MySealActivity extends ActivityPresenter<MySealDelegate> {
    private RecyclerView mRecyclerView;


    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDelegate.initTitle();
        mRecyclerView = mViewDelegate.get(R.id.my_seal_recycler);
        UserInfo userInfo = UserManager.getInstance().getUserInfo();
        final List<byte[]> imgList = new ArrayList<>();
        if (userInfo != null) {
            final List<UserInfo.OfficeSealBean> officeSealBeen = userInfo.getOffice_seal();
            for (int i = 0; i < officeSealBeen.size(); i++) {
                PublicModel.getInstance().getSource(new MSubscribe<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody bean) {
                        super.onNext(bean);
                        try {
                            imgList.add(bean.bytes());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (imgList.size() == officeSealBeen.size()) {
                            MySealAdapter adapter = new MySealAdapter(imgList, MySealActivity.this);
                            mViewDelegate.setRecycler(mRecyclerView, adapter, true);
                        }
                    }
                }, officeSealBeen.get(i).getSource_id());
            }
        }


    }

    @Override
    public Class<MySealDelegate> getDelegateClass() {
        return MySealDelegate.class;
    }
}
