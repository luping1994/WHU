package net.suntrans.whu.bean;


import net.suntrans.whu.netapi.ApiErrorCode;

/**
 * Created by Looney on 2017/9/7.
 */

public class ResultBody<T> {
    public int code;
    public String msg;
    public T data;

    public boolean isOk() {
        return code== ApiErrorCode.OK;
    }
}
