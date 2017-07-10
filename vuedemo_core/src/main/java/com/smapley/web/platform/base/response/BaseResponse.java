package com.smapley.web.platform.base.response;

/**
 * Created by EricNts on 2017/6/8.
 */
public class BaseResponse {

    private int code;
    private String messga;
    private Object data;

    public BaseResponse(ResponseType type) {
        this.code = type.getKey();
        this.messga = type.getValue();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessga() {
        return messga;
    }

    public void setMessga(String messga) {
        this.messga = messga;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
