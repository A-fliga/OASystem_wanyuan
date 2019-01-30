package org.oasystem.mvp.view;

import android.widget.RelativeLayout;

import org.oasystem.R;
import org.oasystem.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/1/6.
 */

public class OfficialDocumentDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_official_document;
    }

    @Override
    public void initWidget() {
    }
    public void showRight(){
        setToolBarRightTv("筛选");
    }
    public RelativeLayout getRight(){
        return getToolBarRight();
    }
}
