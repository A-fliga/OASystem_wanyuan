package org.oasystem.mvp.view;

import android.widget.ImageView;
import android.widget.TextView;

import org.oasystem.R;
import org.oasystem.manager.UserManager;
import org.oasystem.mvp.model.bean.UserInfo;
import org.oasystem.mvp.view.baseDelegate.ViewDelegate;
import org.oasystem.utils.LoadImgUtil;

/**
 * Created by www on 2018/12/29.
 */

public class UserCenterDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_user_center;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("个人中心");
        UserInfo userInfo = UserManager.getInstance().getUserInfo();
        if (userInfo != null) {
            ImageView icon = get(R.id.center_user_icon);
            TextView name = get(R.id.center_user_name);
            TextView unit = get(R.id.center_user_unit);
            LoadImgUtil.loadCirclePic(this.getActivity(), userInfo.getHeadimg(), icon, R.mipmap.center_icon);
            name.setText(userInfo.getName());
            unit.setText(userInfo.getCompany_name());
        }
    }
}
