package org.oasystem_dazhu.mvp.presenter.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.oasystem_dazhu.R;
import org.oasystem_dazhu.constants.Constants;
import org.oasystem_dazhu.mvp.model.bean.IsSigningBean;
import org.oasystem_dazhu.utils.BitmapUtil;

/**
 * Created by www on 2019/1/21.
 */

public class TestActivity extends AppCompatActivity {
    private org.oasystem_dazhu.mvp.view.customView.photoView.DrawPenView view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a123);
        Bitmap bitmap = BitmapUtil.drawableToBitmap(getResources().getDrawable(R.mipmap.ic_launcher));
        EventBus.getDefault().register(this);
        view = findViewById(R.id.newdraw);
        view.setBitmap(bitmap);
        view.initParameter(this);

        view.enable();

        this.view.setImageBitmap(bitmap);
    }

    public void onclick(View view) {
        Bitmap bitmap = this.view.getSourceBitMap();
        BitmapUtil.saveBitmapToSDCard(bitmap, Constants.OFFICE_PREVIEW);
    }

    //是否是签字状态的监听
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void isSigning(IsSigningBean bean) {
        if (bean.isSigning) {
        } else {
//            this.view.setImageBitmap(this.view.getBitmap());
//            view.resetCanvas();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
