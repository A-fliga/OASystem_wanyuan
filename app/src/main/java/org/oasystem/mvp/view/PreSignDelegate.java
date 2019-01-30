package org.oasystem.mvp.view;

import org.oasystem.R;
import org.oasystem.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/1/7.
 */

public class PreSignDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_pre_sign;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("文件预览");
        setToolBarLeftTv("撤销");
        setToolBarRightTv("提交");
    }
}
