package com.smapley.web.platform.base.response;

/**
 * Created by EricNts on 2017/6/8.
 */
public enum ResponseType {

    SUCCESS(2000, "请求成功"),
    FAIL(4000, "请求失败");

    private int key;
    private String value;

    ResponseType(int key, String value) {
        this.key = key;
        this.value = value;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
