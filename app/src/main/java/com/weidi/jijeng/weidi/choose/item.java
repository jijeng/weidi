package com.weidi.jijeng.weidi.choose;

/**
 * Created by Administrator on 2015/8/19.
 */
public class item {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    int picture;
    String message;
    String date;
    public item(){

    }
}
