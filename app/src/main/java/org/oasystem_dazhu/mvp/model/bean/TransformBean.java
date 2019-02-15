package org.oasystem_dazhu.mvp.model.bean;

/**
 * Created by www on 2019/1/24.
 */

public class TransformBean {
    private float currentXOffset;
    private float currentYOffset;
    private float zoom;
    private int currentPage;

    public float getCurrentXOffset() {
        return currentXOffset;
    }

    public void setCurrentXOffset(float currentXOffset) {
        this.currentXOffset = currentXOffset;
    }

    public float getCurrentYOffset() {
        return currentYOffset;
    }

    public void setCurrentYOffset(float currentYOffset) {
        this.currentYOffset = currentYOffset;
    }

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
