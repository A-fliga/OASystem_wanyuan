package org.oasystem_dazhu.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by www on 2019/1/8.
 */

public class ScreenBean implements Serializable {
    //类型
    public int type = 0;
    //发文号
    public String serial = "";
    //文件名
    public String name = "";
    //日期
    public String s_date = "";
    public String e_date = "";
    public String organ = "";

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }

    public String getE_date() {
        return e_date;
    }

    public void setE_date(String e_date) {
        this.e_date = e_date;
    }

    @Override
    public boolean equals(Object obj) {
        ScreenBean other = (ScreenBean) obj;
        if (type != other.type)
            return false;
        if (!serial.equals(other.serial)) {
            return false;
        }
        if (!name.equals(other.name)) {
            return false;
        }
        if (!s_date.equals(other.s_date)) {
            return false;
        }
        if (!e_date.equals(other.e_date)) {
            return false;
        }
        if (!organ.equals(other.organ)) {
            return false;
        }
        return true;
    }
}
