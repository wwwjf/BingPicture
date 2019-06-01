package com.wengjianfeng.bingpicture.mvvm.entity;

public class Data<T> {

    private T data;

    private String errorMsg;

    public Data(T t, String  errorMsg) {
        data = t;
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
