package org.oasystem_wanyuan.mvp.presenter.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.mvp.model.BaseEntity;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.DealWithOptionBean;
import org.oasystem_wanyuan.mvp.view.AddOptionFormDelegate;
import org.oasystem_wanyuan.utils.ToastUtil;

/**
 * Created by www on 2019/5/23.
 */

public class AddOptionFormActivity extends ActivityPresenter<AddOptionFormDelegate>{
    private int mItemId;
    private EditText mAddOptionEt;
    @Override
    public Class<AddOptionFormDelegate> getDelegateClass() {
        return AddOptionFormDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle  = getIntent().getExtras();
        if(bundle != null){
            mItemId = bundle.getInt("itemId");
            String content = bundle.getString("content", "");
            mAddOptionEt = mViewDelegate.get(R.id.add_option_et);
            if(!TextUtils.isEmpty(content)){
                mAddOptionEt.setText(content);
                mAddOptionEt.setSelection(content.length());
            }
        }
        mViewDelegate.getToolBarRightTv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(mAddOptionEt.getText().toString().replaceAll(" ",""))){
                    ToastUtil.s("意见内容不能为空");
                }
                else {
                    toAddOption();
                }
            }
        });
    }

    private void toAddOption() {
        PublicModel.getInstance().addOptionData(new MSubscribe<BaseEntity>() {
            @Override
            public void onNext(BaseEntity bean) {
                super.onNext(bean);
                if(bean.getCode() == 0){
                    ToastUtil.s("操作成功");
                    EventBus.getDefault().post(new DealWithOptionBean());
                    finish();
                }
            }
        },String.valueOf(mItemId), mAddOptionEt.getText().toString().replaceAll(" ",""));
    }
}
