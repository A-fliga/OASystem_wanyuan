package org.oasystem_dazhu.mvp.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.oasystem_dazhu.R;
import org.oasystem_dazhu.http.MSubscribe;
import org.oasystem_dazhu.mvp.adapter.OfficialDocumentAdapter;
import org.oasystem_dazhu.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_dazhu.mvp.model.BaseEntity;
import org.oasystem_dazhu.mvp.model.PublicModel;
import org.oasystem_dazhu.mvp.model.bean.DocumentBean;
import org.oasystem_dazhu.mvp.model.bean.ScreenBean;
import org.oasystem_dazhu.mvp.presenter.activity.OfficialDocumentDetailActivity;
import org.oasystem_dazhu.mvp.presenter.activity.OfficialHandleActivity;
import org.oasystem_dazhu.mvp.presenter.activity.ScreenActivity;
import org.oasystem_dazhu.mvp.presenter.activity.TestActivity;
import org.oasystem_dazhu.mvp.view.OfficialDelegate;
import org.oasystem_dazhu.utils.SortUtl;
import org.oasystem_dazhu.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static org.oasystem_dazhu.utils.SortUtl.POSITIVE;
import static org.oasystem_dazhu.utils.SortUtl.REVERSE;

/**
 * Created by www on 2018/12/29.
 */

public class OfficialFragment extends FragmentPresenter {
    private OfficialDocumentAdapter adapter;
    private List<DocumentBean.DataBean> newBeanList;
    private Boolean isPositive = false;

    @Override
    public Class getDelegateClass() {
        return OfficialDelegate.class;
    }

    @Override
    protected void onFragmentVisible() {

    }

    @Override
    protected void onFragmentHidden() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        getNotDoneList(new ScreenBean());
        viewDelegate.setOnClickListener(onClickListener, R.id.my_office, R.id.official_from_higher,
                R.id.official_from_same, R.id.to_screen, R.id.official_dispatch, R.id.official_from_lower,
                R.id.official_hand_round, R.id.to_sort,R.id.refresh);

    }

    private void getNotDoneList(ScreenBean screenBean) {
        PublicModel.getInstance().getNotDoneDocument(new MSubscribe<BaseEntity<DocumentBean>>() {
            @Override
            public void onNext(final BaseEntity<DocumentBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    if (bean.getData().getData().size() == 0) {
                        ToastUtil.l("暂无数据");
                    }
                    List<DocumentBean.DataBean> beanList = bean.getData().getData();
                    newBeanList = new ArrayList<DocumentBean.DataBean>();
                    if (beanList.size() <= 10) {
                        newBeanList.addAll(beanList);
                    } else {
                        for (int i = 0; i < 10; i++) {
                            newBeanList.add(beanList.get(i));
                        }
                    }
                    RecyclerView recyclerView = viewDelegate.get(R.id.home_recyclerView);
                    adapter = new OfficialDocumentAdapter(false, getActivity(), SortUtl.sort(newBeanList),1);
                    viewDelegate.setRecycler(recyclerView, adapter, true);
                    adapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("done", false);
                            bundle.putSerializable("DocumentDataBean", newBeanList.get(position));
                            startMyActivity(OfficialDocumentDetailActivity.class, bundle);
                        }
                    });
                }

            }
        }, screenBean);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void refreshList(String content) {
        if (content.equals("upLoadSuccess")) {
            getNotDoneList(new ScreenBean());
        }
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //上级来文
                case R.id.official_from_higher:
                    start2Activity(1);
                    break;
                //平级来文
                case R.id.official_from_same:
                    start2Activity(2);
                    break;
                //下级来文
                case R.id.official_from_lower:
                    start2Activity(3);
                    break;
                //发文审批
                case R.id.official_dispatch:
                    start2Activity(4);
                    break;
                //传阅文件
                case R.id.official_hand_round:
                    start2Activity(5);
                    break;
                //内部文件
                case R.id.my_office:
                    start2Activity(6);
                    break;
                //去筛选
                case R.id.to_screen:
                    Intent intent = new Intent(getActivity(), ScreenActivity.class);
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
                    getNotDoneList(new ScreenBean());
                    break;

            }
        }
    };

    private void start2Activity(int typeId) {
        Bundle bundle = new Bundle();
        bundle.putInt("typeId", typeId);
        startMyActivity(OfficialHandleActivity.class, bundle);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 2000) {
            ScreenBean screenBean = (ScreenBean) data.getExtras().getSerializable("screenBean");
            if (screenBean != null) {
                getNotDoneList(screenBean);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}