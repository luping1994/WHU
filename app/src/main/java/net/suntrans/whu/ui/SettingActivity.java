package net.suntrans.whu.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import net.suntrans.whu.R;
import net.suntrans.whu.databinding.ActivitySettingBinding;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public class SettingActivity extends BasedActivity implements View.OnClickListener {

    private ActivitySettingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        binding.layoutBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_back:
                finish();
                break;
        }
    }
}
