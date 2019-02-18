package org.oasystem_dazhu.utils;

import org.oasystem_dazhu.mvp.model.bean.DocumentBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by www on 2019/1/20.
 */

public class SortUtl {
    public static final int REVERSE = -1, POSITIVE = 1;
    public static boolean IS_CREATE = true;
    private static List<DocumentBean.DataBean> totalList, urgentBeanList, notUrgentBeanList;

    public static List<DocumentBean.DataBean> sort(List<DocumentBean.DataBean> beanList, int sortType, Boolean is_create) {
        IS_CREATE = is_create;
        if (beanList.size() < 2) {
            return beanList;
        }
        if (sortType != REVERSE && sortType != POSITIVE)
            return sortNormal(beanList);
        urgentBeanList = new ArrayList<>();
        notUrgentBeanList = new ArrayList<>();

        for (int i = 0; i < beanList.size(); i++) {
            if (beanList.get(i).getDispatch().getUrgent() == 1) {
                urgentBeanList.add(beanList.get(i));
            } else notUrgentBeanList.add(beanList.get(i));
        }
        if (urgentBeanList.size() >= 2) {
            ListSort(urgentBeanList, sortType);
        }
        if (notUrgentBeanList.size() >= 2) {
            ListSort(notUrgentBeanList, sortType);
        }
        totalList = new ArrayList<>();
        if (urgentBeanList.size() != 0)
            totalList.addAll(urgentBeanList);
        if (notUrgentBeanList.size() != 0)
            totalList.addAll(notUrgentBeanList);
        return totalList;
    }

    //默认的排序，加急置顶，其他不变
    public static List<DocumentBean.DataBean> sort(List<DocumentBean.DataBean> beanList) {
        return sortNormal(beanList);
    }

    private static List<DocumentBean.DataBean> sortNormal(List<DocumentBean.DataBean> beanList) {
        if (beanList.size() < 2) {
            return beanList;
        }
        urgentBeanList = new ArrayList<>();
        notUrgentBeanList = new ArrayList<>();

        for (int i = 0; i < beanList.size(); i++) {
            if (beanList.get(i).getDispatch().getUrgent() == 1) {
                urgentBeanList.add(beanList.get(i));
            } else notUrgentBeanList.add(beanList.get(i));
        }
        totalList = new ArrayList<>();
        if (urgentBeanList.size() != 0)
            totalList.addAll(urgentBeanList);
        if (notUrgentBeanList.size() != 0)
            totalList.addAll(notUrgentBeanList);
        return totalList;
    }

    private static void ListSort(List<DocumentBean.DataBean> list, final int sortType) {
        Collections.sort(list, new Comparator<DocumentBean.DataBean>() {
            @Override
            public int compare(DocumentBean.DataBean o1, DocumentBean.DataBean o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date dt1 = format.parse(IS_CREATE ? o1.getDispatch().getCreated_at() : o1.getDispatch().getUpdated_at());
                    Date dt2 = format.parse(IS_CREATE ? o2.getDispatch().getCreated_at() : o2.getDispatch().getUpdated_at());
                    if (dt1.getTime() > dt2.getTime()) {
                        return sortType;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return -sortType;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }
}
