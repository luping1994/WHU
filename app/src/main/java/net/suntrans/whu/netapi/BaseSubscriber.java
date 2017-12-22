package net.suntrans.whu.netapi;

import android.util.Log;

import net.suntrans.whu.netapi.ApiErrorCode;
import net.suntrans.whu.netapi.ApiException;
import net.suntrans.whu.utils.NetworkUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 默认订阅对象实现，可以有选择的实现方法
 * Created by Looney on 2017/7/2.
 */
public class BaseSubscriber<T> implements Subscriber<T> {


    @Override
    public void onSubscribe(Subscription s) {
        if (!NetworkUtils.isNetworkAvailable()) {
            Log.d("netWork", "网络连接不可用");
            this.onError(new ApiException(ApiErrorCode.ERROR_NO_INTERNET, "network interrupt"));
            s.cancel();
            return;
        }
    }

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable e) {
        ApiErrorHelper.handleCommonError(e);
    }

    @Override
    public void onComplete() {

    }
}
