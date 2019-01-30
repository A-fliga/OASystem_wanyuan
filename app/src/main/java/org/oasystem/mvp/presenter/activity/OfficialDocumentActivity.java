package org.oasystem.mvp.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.oasystem.R;
import org.oasystem.http.MSubscribe;
import org.oasystem.mvp.adapter.OfficialDocumentAdapter;
import org.oasystem.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem.mvp.model.BaseEntity;
import org.oasystem.mvp.model.PublicModel;
import org.oasystem.mvp.model.bean.DocumentBean;
import org.oasystem.mvp.model.bean.ScreenBean;
import org.oasystem.mvp.view.OfficialDocumentDelegate;
import org.oasystem.utils.ToastUtil;

/**
 * Created by www on 2019/1/6.
 */

public class OfficialDocumentActivity extends ActivityPresenter<OfficialDocumentDelegate> {
    private Boolean done = false;

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        initTitleView();
        if (done) {
            getDoneDocument(new ScreenBean());
        } else getNotDoneDocument(new ScreenBean());
    }

    private void getNotDoneDocument(ScreenBean screenBean) {
        final RecyclerView recyclerView = viewDelegate.get(R.id.official_document_recycler);
        PublicModel.getInstance().getNotDoneDocument(new MSubscribe<BaseEntity<DocumentBean>>() {
            @Override
            public void onNext(final BaseEntity<DocumentBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    if (bean.getData().getData().size() == 0) {
                        ToastUtil.l("暂无数据");
                    }
//                    viewDelegate.showRight();
//                    viewDelegate.getRight().setOnClickListener(onClickListener);
                    OfficialDocumentAdapter adapter = new OfficialDocumentAdapter(false, OfficialDocumentActivity.this, bean.getData().getData());
                    viewDelegate.setRecycler(recyclerView, adapter, true);
                    adapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("done", done);
                            bundle.putSerializable("DocumentDataBean", bean.getData().getData().get(position));
                            startMyActivity(OfficialDocumentDetailActivity.class, bundle);
                        }
                    });
                }
            }
        }, screenBean);
    }

    private void getDoneDocument(ScreenBean screenBean) {
        final RecyclerView recyclerView = viewDelegate.get(R.id.official_document_recycler);
        PublicModel.getInstance().getDoneDocument(new MSubscribe<BaseEntity<DocumentBean>>() {
            @Override
            public void onNext(final BaseEntity<DocumentBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    if (bean.getData().getData().size() == 0) {
                        ToastUtil.l("暂无数据");
                    }
//                    viewDelegate.showRight();
//                    viewDelegate.getRight().setOnClickListener(onClickListener);
                    OfficialDocumentAdapter adapter = new OfficialDocumentAdapter(false, OfficialDocumentActivity.this, bean.getData().getData());
                    viewDelegate.setRecycler(recyclerView, adapter, true);
                    adapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("done", done);
                            bundle.putSerializable("DocumentBean", bean.getData().getData().get(position).getDispatch());
                            bundle.putInt("itemId", bean.getData().getData().get(position).getId());
                            startMyActivity(OfficialDocumentDetailActivity.class, bundle);
                        }
                    });
                }

            }
        }, screenBean);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.toolbar_right_rl) {

            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 2000) {
            ScreenBean screenBean = (ScreenBean) data.getExtras().getSerializable("screenBean");
            if (screenBean != null) {
                if (done) {
                    getDoneDocument(screenBean);
                } else getNotDoneDocument(screenBean);
            }
        }
    }

    private void initTitleView() {
        done = getIntent().getExtras().getBoolean("done");
//        if (done) {
//            viewDelegate.getTitleView().setText("已办公文");
//        } else {
//            viewDelegate.getTitleView().setText("待办公文");
//        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void refreshList(String content) {
        if (content.equals("upLoadSuccess")) {
            getNotDoneDocument(new ScreenBean());
        }
    }

    @Override
    public Class<OfficialDocumentDelegate> getDelegateClass() {
        return OfficialDocumentDelegate.class;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
