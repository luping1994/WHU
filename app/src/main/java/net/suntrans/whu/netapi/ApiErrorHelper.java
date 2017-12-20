package net.suntrans.whu.netapi;

import android.content.Context;


import net.suntrans.whu.R;
import net.suntrans.whu.utils.UiUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;


/**
 * Created by Looney on 2017/9/6.
 */

public class ApiErrorHelper {
    public static void handleCommonError(final Context context, Throwable e) {
        if (e instanceof HttpException) {
            if (e != null) {
                HttpException exception = (HttpException) e;
                if (e.getMessage() != null) {
                    if (exception.code() == 401) {
                        UiUtils.showToast("账号或密码错误");
                    }else if (exception.code()==500){
                        UiUtils.showToast("服务器内部错误");
                    }else if (exception.code()==404){
                        UiUtils.showToast("404 Not Found");
                    }
                }

            } else {
                UiUtils.showToast("服务暂不可用");
            }
        } else if (e instanceof ApiException) {
            int code = ((ApiException) e).code;
            if (code == ApiErrorCode.UNAUTHORIZED) {

            } else if (code == ApiErrorCode.ERROR_NO_INTERNET) {
                UiUtils.showToast("网络连接不可用");
            } else if (code == ApiErrorCode.ERROR) {
                UiUtils.showToast(((ApiException) e).msg);
            } else {
                UiUtils.showToast(((ApiException) e).msg);
            }
        } else if (e instanceof IOException) {
            if (e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
                UiUtils.showToast("连接失败,请重试！");
            } else {
                UiUtils.showToast(context.getString(R.string.tips_net_work_is_unused));
            }

        } else {
            UiUtils.showToast("出错了!!!");
        }
    }
}
