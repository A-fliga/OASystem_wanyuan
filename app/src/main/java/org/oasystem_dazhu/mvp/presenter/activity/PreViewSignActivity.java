package org.oasystem_dazhu.mvp.presenter.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.oasystem_dazhu.R;
import org.oasystem_dazhu.http.MSubscribe;
import org.oasystem_dazhu.mvp.model.BaseEntity;
import org.oasystem_dazhu.mvp.model.PublicModel;
import org.oasystem_dazhu.mvp.model.bean.UpFileBean;
import org.oasystem_dazhu.mvp.view.PreSignDelegate;
import org.oasystem_dazhu.utils.DialogUtil;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by www on 2019/1/7.
 */

public class PreViewSignActivity extends ActivityPresenter<PreSignDelegate> {
//    private PDFView pdfView;
    private String path;
    private int upLoadId;
    private int orignalId;
    private ArrayList<Integer> accessoryList;
    private String accessory_source_id;
    private String form_source_id;

    @Override
    public Class<PreSignDelegate> getDelegateClass() {
        return PreSignDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accessoryList = new ArrayList<>();
        path = getIntent().getExtras().getString("newPath");
        orignalId = getIntent().getExtras().getInt("itemId");
        accessoryList = getIntent().getExtras().getIntegerArrayList("accessoryList");
//        pdfView = viewDelegate.get(R.id.pdfView);
//        pdfView.fromFile(new File(path)).swipeHorizontal(true).pageSnap(true)
//                .autoSpacing(true)
//                .pageFling(true);
//        pdfView.setMaxZoom(1f);
        viewDelegate.getToolBarRight().setOnClickListener(onClickListener);
        viewDelegate.getToolBarLeftTv().setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.toolbar_left_tv:
                    finish();
                    break;
                case R.id.toolbar_right_rl:
                    DialogUtil.showDialog(PreViewSignActivity.this, "您确定要提交吗？", "确定", "取消", mOnclickListener);
                    break;
            }
        }
    };

    private DialogInterface.OnClickListener mOnclickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -1) {
                upLoadFile();
            }
            dialogInterface.dismiss();
        }
    };

    private void upLoadFile() {
        File file = new File(path);
        PublicModel.getInstance().upload_file(new MSubscribe<BaseEntity<UpFileBean>>() {
            @Override
            public void onNext(BaseEntity<UpFileBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    upLoadId = bean.getData().getId();
                    examine(String.valueOf(upLoadId));
                }
            }
        }, file);
    }

    private void examine(String id) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < accessoryList.size(); i++) {
            if (i == accessoryList.size() - 1) {
                int formId = accessoryList.get(i);
                if (formId == -1) {
                    form_source_id = id;
                } else {
                    form_source_id = String.valueOf(formId);
                }
            } else {

                int tagId = accessoryList.get(i);
                if (tagId != -1) {
                    sb.append(String.valueOf(accessoryList.get(i))).append("#");
                } else sb.append(id).append("#");
            }
        }
        accessory_source_id = sb.substring(0, sb.length() - 1);
        PublicModel.getInstance().examine(new MSubscribe<BaseEntity>() {
            @Override
            public void onNext(BaseEntity bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    EventBus.getDefault().post("upLoadSuccess");
                   DialogUtil.showDialog(PreViewSignActivity.this,"文件已上传成功","确定",onclickListener);
                }
            }
        }, String.valueOf(orignalId), "1", accessory_source_id, form_source_id);
    }

    private DialogInterface.OnClickListener onclickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            finish();
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        pdfView.stopFling();
    }
}
