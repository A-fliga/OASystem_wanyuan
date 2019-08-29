package org.oasystem_wanyuan.mvp.view;


import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/2/16.
 */

public class FileMonitorDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_file_monitor;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("文件监控");
    }

}
