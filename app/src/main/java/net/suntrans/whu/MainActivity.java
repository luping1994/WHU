package net.suntrans.whu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import net.suntrans.whu.adapter.FragmentAdapter;
import net.suntrans.whu.databinding.ActivityMainBinding;
import net.suntrans.whu.ui.BasedActivity;
import net.suntrans.whu.ui.fragment.RoomFragment;
import net.suntrans.whu.utils.StatusBarCompat;

/**
 * Created by Looney on 2017/12/19.
 * Des:
 */

public class MainActivity extends BasedActivity {

    private final String TAG = this.getClass().getSimpleName();
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        StatusBarCompat.compat(binding.statusbar);
        RoomFragment roomFragment = new RoomFragment();
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(roomFragment, "roomFragment");
        binding.viewpager.setAdapter(adapter);
    }


}
