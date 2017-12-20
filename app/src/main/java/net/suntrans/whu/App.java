package net.suntrans.whu;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Looney on 2017/12/20.
 * Des:
 */

public class App extends Application {
    public static SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences =  application.getSharedPreferences("suntrans_whu",Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static Application getApplication() {
        return application;
    }

    private static Application application;

    private static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
    }

}
