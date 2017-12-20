package net.suntrans.whu.core.manager;

import net.suntrans.whu.netapi.Api;
import net.suntrans.whu.netapi.RetrofitHelper;
import net.suntrans.whu.bean.ResultBody;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Looney on 2017/12/20.
 * Des:
 */

public class RemoteLoginDataSource extends BaseDataSource implements LoginDataSource{

    private Api api;

    public RemoteLoginDataSource() {
        this.api = RetrofitHelper.getApi();
    }

    public Flowable<ResultBody> login(Map<String, String> map) {
        return api.login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
