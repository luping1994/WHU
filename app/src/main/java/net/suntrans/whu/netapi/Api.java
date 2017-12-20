package net.suntrans.whu.netapi;
import net.suntrans.whu.bean.ResultBody;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Looney on 2017/1/4.
 */

public interface Api {


    /**
     * 登录
     *
     * @param
     * @return
     */
    @FormUrlEncoded
    @POST("/oauth/token")
    Flowable<ResultBody> login(@FieldMap Map<String,String> map);
}
