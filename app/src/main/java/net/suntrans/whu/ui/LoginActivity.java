package net.suntrans.whu.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.jakewharton.rxbinding2.view.RxView;

import net.suntrans.whu.App;
import net.suntrans.whu.MainActivity;
import net.suntrans.whu.R;
import net.suntrans.whu.core.manager.LoginDataSource;
import net.suntrans.whu.core.manager.RemoteLoginDataSource;
import net.suntrans.whu.databinding.ActivityLoginBinding;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class LoginActivity extends BasedActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private ActivityLoginBinding binding;

    private LoginDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        init();

    }

    private void init() {
        dataSource = new RemoteLoginDataSource();
        binding.auto.setOnCheckedChangeListener(this);
        binding.remember.setOnCheckedChangeListener(this);
        RxView.clicks(binding.login)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.auto:
                App.getSharedPreferences().edit()
                        .putBoolean("auto", isChecked)
                        .commit();
                break;
            case R.id.remember:
                App.getSharedPreferences().edit()
                        .putBoolean("remember", isChecked)
                        .commit();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:

                break;
        }
    }
}
