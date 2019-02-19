package org.oasystem_wanyuan.mvp.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.mvp.adapter.OfficialDocumentAdapter;
import org.oasystem_wanyuan.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_wanyuan.mvp.model.BaseEntity;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.DocumentBean;
import org.oasystem_wanyuan.mvp.model.bean.ScreenBean;
import org.oasystem_wanyuan.mvp.view.FileMonitorDelegate;
import org.oasystem_wanyuan.utils.SortUtl;
import org.oasystem_wanyuan.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static org.oasystem_wanyuan.utils.SortUtl.POSITIVE;
import static org.oasystem_wanyuan.utils.SortUtl.REVERSE;


/**
 * Created by www on 2019/2/16.
 */

public class FileMonitorActivity extends ActivityPresenter<FileMonitorDelegate> {
    private OfficialDocumentAdapter adapter;
    private List<DocumentBean.DataBean> newBeanList;
    private Boolean isPositive_create = false, isPositive_update = false;
    private ScreenBean screenBean;

    @Override
    public Class<FileMonitorDelegate> getDelegateClass() {
        return FileMonitorDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewDelegate.setOnClickListener(onClickListener, R.id.to_screen, R.id.to_sort_create, R.id.to_sort_update, R.id.refresh);

        getFileMonitorList(new ScreenBean());
    }

    private void getFileMonitorList(ScreenBean screenBean) {
        PublicModel.getInstance().getMonitorList(new MSubscribe<BaseEntity<DocumentBean>>() {
            @Override
            public void onNext(BaseEntity<DocumentBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    if (bean.getData().getData().size() == 0) {
                        ToastUtil.l("暂无数据");
                    }
                    newBeanList = new ArrayList<DocumentBean.DataBean>();
                    newBeanList.addAll(bean.getData().getData());
                    RecyclerView recyclerView = viewDelegate.get(R.id.file_monitor_recyclerView);
                    adapter = new OfficialDocumentAdapter(false, FileMonitorActivity.this, SortUtl.sort(newBeanList));
                    viewDelegate.setRecycler(recyclerView, adapter, true);
                    adapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("done", true);
                            bundle.putSerializable("DocumentDataBean", newBeanList.get(position));
                            startMyActivity(OfficialDocumentDetailActivity.class, bundle);
                        }
                    });
                }
            }
        }, screenBean);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //去筛选
                case R.id.to_screen:
                    Intent intent = new Intent(FileMonitorActivity.this, ScreenActivity.class);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("needShowTop", true);
                    if (screenBean == null)
                        screenBean = new ScreenBean();
                    bundle2.putSerializable("localScreenBean", screenBean);
                    intent.putExtras(bundle2);
                    startActivityForResult(intent, 1000);
                    break;

                case R.id.to_sort_create:
                    isPositive_create = !isPositive_create;
                    isPositive_update = false;
                    adapter.setBeanList(SortUtl.sort(newBeanList, isPositive_create ? POSITIVE : REVERSE, true));
                    adapter.notifyDataSetChanged();
                case R.id.to_sort_update:
                    isPositive_update = !isPositive_update;
                    isPositive_create = false;
                    adapter.setBeanList(SortUtl.sort(newBeanList, isPositive_update ? POSITIVE : REVERSE, false));
                    adapter.notifyDataSetChanged();
                    break;
                case R.id.refresh:
                    isPositive_update = false;
                    isPositive_create = false;
                    getFileMonitorList(new ScreenBean());
                    break;

            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 2000) {
            screenBean = (ScreenBean) data.getExtras().getSerializable("screenBean");
            if (screenBean != null) {
                getFileMonitorList(screenBean);
            }
        }
    }
}
