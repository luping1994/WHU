package net.suntrans.whu.RxUtil;

import android.util.Log;

import net.suntrans.whu.netapi.ApiErrorCode;
import net.suntrans.whu.netapi.ApiException;
import net.suntrans.whu.utils.NetworkUtils;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 默认订阅对象实现，可以有选择的实现方法
 * Created by linxiao on 2017/7/2.
 */
public class BaseSubscriber<T> implements Observer<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        if (!NetworkUtils.isNetworkAvailable()) {
            Log.d("netWork", "网络连接不可用");
            this.onError(new ApiException(ApiErrorCode.ERROR_NO_INTERNET, "network interrupt"));
            d.dispose();
            return;
        }
    }

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
