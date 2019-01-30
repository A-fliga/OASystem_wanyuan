package org.oasystem.mvp.view;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.oasystem.R;
import org.oasystem.manager.UserManager;
import org.oasystem.mvp.model.bean.LoginBean;
import org.oasystem.mvp.model.bean.UserInfo;
import org.oasystem.mvp.view.baseDelegate.ViewDelegate;
import org.oasystem.utils.LoadImgUtil;

/**
 * Created by www on 2018/12/29.
 */

public class OfficialDelegate extends ViewDelegate {
    private ImageView home_user_icon;
    private TextView home_user_name, home_user_unit;

    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_official;
    }

    @Override
    public void initWidget() {
        home_user_icon = get(R.id.home_user_icon);
        home_user_name = get(R.id.home_user_name);
        home_user_unit = get(R.id.home_user_unit);

        UserInfo userInfo = UserManager.getInstance().getUserInfo();
        if (userInfo != null) {
            LoadImgUtil.loadCirclePic(this.getActivity(),userInfo.getHeadimg(),home_user_icon,R.mipmap.home_user_icon);
            home_user_name.setText(userInfo.getName());
            home_user_unit.setText(userInfo.getCompany_name());
        }

    }
}
