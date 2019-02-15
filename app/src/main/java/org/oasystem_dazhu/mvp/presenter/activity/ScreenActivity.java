package org.oasystem_dazhu.mvp.presenter.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import org.oasystem_dazhu.R;
import org.oasystem_dazhu.mvp.adapter.ScreenTypeAdapter;
import org.oasystem_dazhu.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_dazhu.mvp.model.bean.ScreenBean;
import org.oasystem_dazhu.mvp.view.ScreenDelegate;
import org.oasystem_dazhu.utils.DialogUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by www on 2019/1/8.
 */

public class ScreenActivity extends ActivityPresenter<ScreenDelegate> {
    private List<String> beanList;
    private ScreenBean screenBean;
    private ScreenTypeAdapter adapter;
    private TextView s_date, e_date;
    private EditText office_name, office_serial, office_organ, office_number;
    private int opType = 0;
    private DatePicker datePicker;
    private List<Map<Integer, Boolean>> selectedType;

    @Override
    public Class<ScreenDelegate> getDelegateClass() {
        return ScreenDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenBean = new ScreenBean();
        initView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getBoolean("needShowTop"))
            initTypeList();
        else {
            viewDelegate.get(R.id.screen_top_line).setVisibility(View.GONE);
            viewDelegate.get(R.id.screen_type_tv).setVisibility(View.GONE);
        }
        viewDelegate.setOnClickListener(onClickListener, R.id.s_date, R.id.e_date, R.id.screen_reset, R.id.screen_sure);

    }

    private void initView() {
        s_date = viewDelegate.get(R.id.s_date);
        e_date = viewDelegate.get(R.id.e_date);
        office_name = viewDelegate.get(R.id.office_name);
        office_serial = viewDelegate.get(R.id.office_serial);
        office_organ = viewDelegate.get(R.id.office_organ);
        office_number = viewDelegate.get(R.id.office_number);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //选择起始时间
                case R.id.s_date:
                    opType = 2;
                    setDate();
                    break;
                //选择结束时间
                case R.id.e_date:
                    opType = 3;
                    setDate();
                    break;
                //重置
                case R.id.screen_reset:
                    opType = 1;
                    DialogUtil.showDialog(ScreenActivity.this, "您确定要重置吗？", "确定", "取消", mOnClickListener);

                    break;
                //确定
                case R.id.screen_sure:
                    returnToOrg();
                    break;
            }
        }
    };

    private void returnToOrg() {
        if (selectedType != null) {
            List<Map<Integer, Boolean>> list = adapter.getList();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get(i + 1)) {
                    sb.append((i + 1) + ",");
                }
            }
            if (sb.length() >= 1)
                screenBean.setType(sb.substring(0, sb.length() - 1));
            else screenBean.setType("");
        }
        screenBean.setSerial(office_serial.getText().toString().replaceAll(" ", ""));
        screenBean.setName(office_name.getText().toString().replaceAll(" ", ""));
        screenBean.setOrgan(office_organ.getText().toString().replaceAll(" ", ""));
        screenBean.setNumber(office_number.getText().toString().replaceAll(" ", ""));
        ScreenBean newBean = new ScreenBean();
        if (screenBean.equals(newBean)) {
            finish();
        } else {
            Bundle bundle = new Bundle();
            bundle.putSerializable("screenBean", screenBean);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(2000, intent);
            finish();
        }
    }


    public void setDate() {
        final Calendar calendar = Calendar.getInstance();
        //通过自定义控件AlertDialog实现
        AlertDialog.Builder builder = new AlertDialog.Builder(ScreenActivity.this);
        View view = getLayoutInflater().inflate(R.layout.data_dialog, null);
        datePicker = (DatePicker) view.findViewById(R.id.date_picker);
        //设置日期简略显示 否则详细显示 包括:星期\周
        datePicker.setCalendarViewShown(false);
        //初始化当前日期
        calendar.setTimeInMillis(System.currentTimeMillis());
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), null);
        //设置date布局
        builder.setView(view);
        builder.setTitle("请选择日期");
        builder.setPositiveButton("确  定", mOnClickListener);
        builder.setNegativeButton("取  消", mOnClickListener);
        builder.create().show();
    }

    private DialogInterface.OnClickListener mOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (opType == 1 && i == -1) {
                reset();
            }
            if (i == -1) {
                if (opType == 2) {
                    setDataMsg(2);
                }
                if (opType == 3) {
                    setDataMsg(3);
                }
            }
            dialogInterface.dismiss();
        }
    };

    private void setDataMsg(int opType) {
        //日期格式
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("%d-%02d-%02d",
                datePicker.getYear(),
                datePicker.getMonth() + 1,
                datePicker.getDayOfMonth()));
        if (opType == 2) {
            screenBean.setS_date(stringBuffer.toString());
            s_date.setText(stringBuffer.toString());
        }
        if (opType == 3) {
            screenBean.setE_date(stringBuffer.toString());
            e_date.setText(stringBuffer.toString());
        }
    }

    private void reset() {
        screenBean.setType("");
        screenBean.setE_date("");
        screenBean.setName("");
        screenBean.setSerial("");
        screenBean.setS_date("");
        screenBean.setOrgan("");
        if (adapter != null) {
            adapter.clearSelected();
        }
        s_date.setText("");
        e_date.setText("");
        office_name.setText("");
        office_serial.setText("");
        office_organ.setText("");
    }

    private void initTypeList() {
        beanList = new ArrayList<>();
        beanList.add("上级来文");
        beanList.add("平级来文");
        beanList.add("下级来文");
        beanList.add("发文审批");
        beanList.add("传阅文件");
        beanList.add("内部文件");
        selectedType = new ArrayList<>();
        for (int i = 0; i < beanList.size(); i++) {
            Map<Integer, Boolean> map = new HashMap<>();
            map.put(i + 1, false);
            selectedType.add(map);
        }
        RecyclerView recyclerView = viewDelegate.get(R.id.screen_recyclerView);
        adapter = new ScreenTypeAdapter(beanList, selectedType, this);
        viewDelegate.setRecycler(recyclerView, adapter, 4, false);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
    }
}
