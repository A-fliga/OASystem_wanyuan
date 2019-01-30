package org.oasystem.mvp.view;

import org.oasystem.R;
import org.oasystem.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/1/5.
 */

public class MyOfficeDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_my_office;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("个人文档");
    }
}
