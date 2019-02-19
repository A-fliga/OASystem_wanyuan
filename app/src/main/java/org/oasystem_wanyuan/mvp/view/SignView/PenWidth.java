package org.oasystem_wanyuan.mvp.view.SignView;

/**
 * Created by www on 2018/12/12.
 */

public enum PenWidth {
    DEFAULT(10f, 0), TWELVE(20f, 2), ELEVEN(15f, 1), THIRTEEN(25f, 3),

    FOURTEEN(30f, 4), FIFTEEN(35f, 5);
    private float width;
    private int key;

    PenWidth(float width, int key) {
        this.width = width;
        this.key = key;
    }

    public float getWidth() {
        return width;
    }
    public int getKey(){
        return key;
    }

    public static float getWidthByKey(int key){
        for (PenWidth penwidth :
                PenWidth.values()) {
            int k = penwidth.getKey();
            if(k == key){
                return penwidth.getWidth();
            }
            
        }
        return -1;
    }

    public static int getKeyByValue(float value){
        for (PenWidth penWidth:
             PenWidth.values()) {
            float v = penWidth.getWidth();
            if(v == value)
                return penWidth.getKey();
        }
        return -1;
    }
}
