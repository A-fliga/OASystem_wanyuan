package org.oasystem_wanyuan.mvp.view.SignView;

import android.graphics.Color;

/**
 * @author www
 */
public interface IPenConfig {

    /**
     * 清除画布
     */
    int STROKE_TYPE_ERASER = 0;

    /**
     * 钢笔
     */
    int STROKE_TYPE_PEN = 1;// 钢笔

    //设置笔的宽度
    int PEN_WIDTH = 60;
    //笔的颜色
    int PEN_CORLOUR = Color.parseColor("#000000");

    //这个控制笔锋的控制值
    float DIS_VEL_CAL_FACTOR = 0.01f;
    //手指在移动的控制笔的变化率  这个值越大，线条的粗细越加明显
    //float WIDTH_THRES_MAX = 0.6f;
    float WIDTH_THRES_MAX = 10f;
    //绘制计算的次数，数值越小计算的次数越多，需要折中
    int STEPFACTOR = 20;
}
