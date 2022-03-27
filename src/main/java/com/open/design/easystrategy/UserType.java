package com.open.design.easystrategy;

/**
 * @Author liuxiaowei
 * @Date 2021/2/22 21:32
 * @Description
 */
public enum UserType {
    NO_VIP(0,"普通会员"),SILVER_VIP(1,"白银会员"), GOLD_VIP(2,"黄金会员"), PLATINUM_VIP(3,"白金会员");

    private Integer type;
    private String code;

    UserType(Integer type,String code) {
        this.type = type;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Integer getType() {
        return type;
    }
}
