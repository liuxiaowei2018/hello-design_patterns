package com.open.extension;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author liuxiaowei
 * @date 2022年03月14日 14:01
 * @Description
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("ALL")
public class R<T> implements Serializable {

    private static final long serialVersionUID = 7410889986427304506L;

    public static final String DEF_ERROR_MESSAGE = "系统繁忙，请稍候再试";
    public static final String HYSTRIX_ERROR_MESSAGE = "请求超时，请稍候再试";
    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "响应成功";
    public static final int FAIL_CODE = -1;
    public static final int TIMEOUT_CODE = -2;

    /**
     * 响应编码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 附加数据
     */
    private Map<Object, Object> extra;

    /**
     * 响应时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timestamp = new Date();

    public R() {
        super();
    }

    @JsonIgnore
    public boolean isSuccess() {
        return Objects.equals(SUCCESS_CODE,code) || this.code == 200;
    }

    @JsonIgnore
    public boolean isError() {
        return !isSuccess();
    }

    public static <T> R<T> success() {
        return success(null, SUCCESS_MSG);
    }

    public static <T> R<T> success(T data) {
        return success(data, SUCCESS_MSG);
    }

    public static <T> R<T> success(T data,String message) {
        R<T> result = new R<>();
        result.code = SUCCESS_CODE;
        result.data = data;
        result.message = message;
        return result;
    }

    public static <T> R<T> timeout() {
        return error(HYSTRIX_ERROR_MESSAGE);
    }

    public R<T> put(String key, Object value) {
        if (this.extra == null) {
            this.extra = new HashMap<>(16);
        }
        this.extra.put(key, value);
        return this;
    }

    public R<T> putAll(Map<Object, Object> extra) {
        if (this.extra == null) {
            this.extra = new HashMap<>(16);
        }
        this.extra.putAll(extra);
        return this;
    }

    @Override
    public String toString() {
        return JsonUtils.obj2json(this);
    }

    @Deprecated
    public static <T> R<T> error(String message) {
        R<T> result = new R<>();
        result.code = FAIL_CODE;
        result.message = message;
        return result;
    }
}
