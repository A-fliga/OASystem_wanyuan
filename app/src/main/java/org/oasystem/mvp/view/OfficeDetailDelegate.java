package org.oasystem.mvp.view;

import org.oasystem.R;
import org.oasystem.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/1/5.
 */

public class OfficeDetailDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_office_detail;
    }

    @Override
    public void initWidget() {
    }
}
