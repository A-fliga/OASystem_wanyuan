package org.oasystem_wanyuan.mvp.view.SignView;

import android.graphics.Color;


/**
 * Created by www on 2018/12/12.
 */

public enum PenColor {
    BLACK(Color.BLACK,0),GRAY(Color.GRAY,1),RED(Color.RED,2),GREEN(Color.GREEN,3),BLUE(Color.BLUE,4),
    YELLOW(Color.YELLOW,5),CYAN(Color.CYAN,6);


    private int color;
    private int key;

    PenColor(int color, int key) {
        this.color = color;
        this.key = key;
    }

    public int getColor() {
        return color;
    }

    public int getKey() {
        return key;
    }

    public static int getColorByKey(int key){
        for (PenColor color :
                PenColor.values()) {
            int k = color.getKey();
            if(k == key){
                return color.getColor();
            }

        }
        return -1;
    }

    public static int getKeyByColor(float value){
        for (PenColor color:
                PenColor.values()) {
            int v = color.getColor();
            if(v == value)
                return color.getKey();
        }
        return -1;
    }
}
