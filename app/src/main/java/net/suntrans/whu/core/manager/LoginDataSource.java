package net.suntrans.whu.core.manager;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by Looney on 2017/12/20.
 * Des:
 */

public interface LoginDataSource {
    Flowable login(Map<String, String> map);
}
