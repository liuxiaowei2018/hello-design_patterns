package com.open.design.routertree.example.entity;

/**
 * @author liuxiaowei
 * @date 2022年03月30日 12:43
 * @Description
 */
public class ResEntity {

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResEntity (){
        code = 200;
        message = "success";
    }
}
