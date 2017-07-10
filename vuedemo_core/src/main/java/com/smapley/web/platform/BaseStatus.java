package com.smapley.web.platform;

public enum BaseStatus {
    NORMAL(0, "正常"),
    WAIT(10, "等待"),
    FORBID(20, "禁止"),
    SUCCESS(30, "成功"),
    FAIL(40, "失败");

    private int key;
    private String value;

    BaseStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean equals(BaseStatus status) {
        if (getValue().equals(status.getValue()))
            return true;
        return false;
    }

    public String getValue(int key) {
        for (BaseStatus logger : BaseStatus.values()) {
            if (logger.key == key) {
                return logger.value;
            }
        }
        return null;
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
