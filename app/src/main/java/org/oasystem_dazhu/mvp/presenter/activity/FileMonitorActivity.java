package org.oasystem_dazhu.mvp.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.http.MSubscribe;
import org.oasystem_dazhu.mvp.adapter.OfficialDocumentAdapter;
import org.oasystem_dazhu.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_dazhu.mvp.model.BaseEntity;
import org.oasystem_dazhu.mvp.model.PublicModel;
import org.oasystem_dazhu.mvp.model.bean.DocumentBean;
import org.oasystem_dazhu.mvp.model.bean.ScreenBean;
import org.oasystem_dazhu.mvp.view.FileMonitorDelegate;
import org.oasystem_dazhu.utils.SortUtl;
import org.oasystem_dazhu.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static org.oasystem_dazhu.utils.SortUtl.POSITIVE;
import static org.oasystem_dazhu.utils.SortUtl.REVERSE;


/**
 * Created by www on 2019/2/16.
 */

public class FileMonitorActivity extends ActivityPresenter<FileMonitorDelegate> {
    private OfficialDocumentAdapter adapter;
    private List<DocumentBean.DataBean> newBeanList;
    private Boolean isPositive = false;

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

        viewDelegate.setOnClickListener(onClickListener, R.id.to_screen, R.id.to_sort, R.id.refresh);

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
                    intent.putExtras(bundle2);
                    startActivityForResult(intent, 1000);
                    break;

                case R.id.to_sort:
                    isPositive = !isPositive;
                    adapter.setBeanList(SortUtl.sort(newBeanList, isPositive ? POSITIVE : REVERSE));
                    adapter.notifyDataSetChanged();
                    break;
                case R.id.refresh:
                    getFileMonitorList(new ScreenBean());
                    break;

            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 2000) {
            ScreenBean screenBean = (ScreenBean) data.getExtras().getSerializable("screenBean");
            if (screenBean != null) {
                getFileMonitorList(screenBean);
            }
        }
    }
}
