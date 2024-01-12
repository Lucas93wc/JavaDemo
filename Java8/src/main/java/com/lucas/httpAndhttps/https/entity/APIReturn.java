package com.lucas.httpAndhttps.https.entity;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-15 9:26
 */
public class APIReturn<T> {
    private String code;
    private String msg;
    private T data;
    private Boolean status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
