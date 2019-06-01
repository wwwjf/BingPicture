package com.wengjianfeng.bingpicture.mvvm.entity;

public class TooltipsBean {


    /**
     * loading : Loading...
     * previous : Previous image
     * next : Next image
     * walle : This image is not available to download as wallpaper.
     * walls : Download this image. Use of this image is restricted to wallpaper only.
     */

    private String loading;
    private String previous;
    private String next;
    private String walle;
    private String walls;

    public String getLoading() {
        return loading;
    }

    public void setLoading(String loading) {
        this.loading = loading;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getWalle() {
        return walle;
    }

    public void setWalle(String walle) {
        this.walle = walle;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }
}
