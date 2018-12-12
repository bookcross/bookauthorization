package com.trembear.bookauthorization.enums;

/**
 * redis 枚举
 * @author MaChuang
 * @since 2018/7/30
 */
public enum RedisBusinessCode {

   UCARBBS(123,"神州优车论坛");
    private Integer code;
    private String text;

    RedisBusinessCode(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
