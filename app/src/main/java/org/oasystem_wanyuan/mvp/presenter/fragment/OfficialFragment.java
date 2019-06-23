package org.oasystem_wanyuan.mvp.presenter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.manager.FirmingTypeManager;
import org.oasystem_wanyuan.mvp.adapter.HomeBusinessManagerAdapter;
import org.oasystem_wanyuan.mvp.adapter.HomeTypeAdapter;
import org.oasystem_wanyuan.mvp.adapter.OfficialDocumentAdapter;
import org.oasystem_wanyuan.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_wanyuan.mvp.model.BaseEntity;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.DocumentBean;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;
import org.oasystem_wanyuan.mvp.model.bean.ScreenBean;
import org.oasystem_wanyuan.mvp.presenter.activity.AttendanceActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.CarManagementActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.FileMonitorActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.MainActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.MeetingsActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.OfficialDocumentDetailActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.OfficialHandleActivity;
import org.oasystem_wanyuan.mvp.presenter.activity.ScreenActivity;
import org.oasystem_wanyuan.mvp.view.OfficialDelegate;
import org.oasystem_wanyuan.utils.SortUtl;
import org.oasystem_wanyuan.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import static org.oasystem_wanyuan.utils.SortUtl.POSITIVE;
import static org.oasystem_wanyuan.utils.SortUtl.REVERSE;

/**
 * Created by www on 2018/12/29.
 */

public class OfficialFragment extends FragmentPresenter<OfficialDelegate> {
    private OfficialDocumentAdapter adapter;
    private List<DocumentBean.DataBean> newBeanList;
    private Boolean isPositive_create = false, isPositive_update = false;
    private HomeTypeAdapter typeAdapter;
    private HomeBusinessManagerAdapter managerAdapter;
    private ScreenBean screenBean;

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
        typeAdapter = viewDelegate.initTypeList();
        managerAdapter = viewDelegate.initManagerAdapter();
        getNotDoneList(new ScreenBean());
        viewDelegate.setOnClickListener(onClickListener,
                R.id.to_screen, R.id.to_sort_create, R.id.to_sort_update, R.id.refresh, R.id.home_user_icon);
        setOnItemClickListener();
//        Glide.with(this).load(UserManager.getInstance().getUserInfo().getCompany().getCompany_logo()).into((ImageView) viewDelegate.get(R.id.home_logo));
    }

    private void setOnItemClickListener() {
        typeAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //这些是固定分类
                if (position <= FirmingTypeManager.getInstance().getBeanList().size() - 1) {
                    start2Activity(FirmingTypeManager.getInstance().getBeanList().get(position).getId());
                }
                //有多的代表有文件监控
                else {
                    startMyActivity(FileMonitorActivity.class, null);
                }
            }
        });

        managerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        startMyActivity(AttendanceActivity.class, null);
                        break;
                    case 1:
                        startMyActivity(MeetingsActivity.class, null);
                        break;
                    case 2:
                        startMyActivity(CarManagementActivity.class, null);
                        break;
                }
            }
        });
    }


    private void getNotDoneList(ScreenBean screenBean) {
        PublicModel.getInstance().getNotDoneDocument(new MSubscribe<BaseEntity<DocumentBean>>() {
            @Override
            public void onNext(final BaseEntity<DocumentBean> bean) {
                super.onNext(bean);
                if (bean.getCode() == 0) {
                    if (bean.getData().getData().size() == 0) {
                        ToastUtil.s("暂无数据");
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
                    newBeanList = (SortUtl.sort(newBeanList));
                    RecyclerView recyclerView = viewDelegate.get(R.id.home_recyclerView);
                    adapter = new OfficialDocumentAdapter(false, getActivity(), newBeanList);
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

    private void getFirmingType() {
        PublicModel.getInstance().getType(new MSubscribe<BaseEntity<HomeTypeBean>>() {
            @Override
            public void onNext(BaseEntity<HomeTypeBean> bean) {
                super.onNext(bean);
                List<HomeTypeBean.DataBean> beanList = new ArrayList<HomeTypeBean.DataBean>();
                beanList.addAll(bean.getData().getData());
//                for (int i = 0; i < 3; i++) {
//                    HomeTypeBean.DataBean bean1 = new HomeTypeBean.DataBean();
//                    if (i == 0) {
//                        bean1.setName("会议管理");
//                    }
//                    if (i == 1) {
//                        bean1.setName("考勤管理");
//                    }
//                    if (i == 2) {
//                        bean1.setName("用车管理");
//                    }
//                    bean1.setDispatch_flow_list_count(0);
//                    beanList.add(bean1);
//                }
                FirmingTypeManager.getInstance().addBeanList(beanList);
                typeAdapter = viewDelegate.initTypeList();
                setOnItemClickListener();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void refreshList(String content) {
        if (content.equals("upLoadSuccess")) {
            getNotDoneList(new ScreenBean());
            getFirmingType();
        }
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //去筛选
                case R.id.to_screen:
                    Intent intent = new Intent(getActivity(), ScreenActivity.class);
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
                    newBeanList = SortUtl.sort(newBeanList, isPositive_create ? POSITIVE : REVERSE, true);
                    adapter.setBeanList(newBeanList);
                    adapter.notifyDataSetChanged();
                    break;
                case R.id.to_sort_update:
                    isPositive_create = false;
                    isPositive_update = !isPositive_update;
                    newBeanList = SortUtl.sort(newBeanList, isPositive_update ? POSITIVE : REVERSE, false);
                    adapter.setBeanList(newBeanList);
                    adapter.notifyDataSetChanged();
                    break;
                case R.id.refresh:
                    isPositive_update = false;
                    isPositive_create = false;
                    if (newBeanList != null) {
                        newBeanList.clear();
                    }
                    getNotDoneList(new ScreenBean());
                    getFirmingType();
                    break;

                case R.id.home_user_icon:
                    MainActivity activity = (MainActivity) getActivity();
                    if (activity != null) {
                        activity.viewPager.setCurrentItem(1);
                        Menu menu = activity.navigation.getMenu();
                        menu.getItem(1).setChecked(true);
                    }
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
            screenBean = (ScreenBean) data.getExtras().getSerializable("screenBean");
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

    @Override
    public Class<OfficialDelegate> getDelegateClass() {
        return OfficialDelegate.class;
    }
}
