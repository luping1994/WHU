package net.suntrans.whu;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import net.suntrans.whu.adapter.FragmentAdapter;
import net.suntrans.whu.databinding.ActivityMainBinding;
import net.suntrans.whu.ui.BasedActivity;
import net.suntrans.whu.ui.SettingActivity;
import net.suntrans.whu.ui.fragment.RoomFragment;
import net.suntrans.whu.ui.fragment.StudentFragment;
import net.suntrans.whu.ui.fragment.ZongheFragment;
import net.suntrans.whu.utils.StatusBarCompat;

/**
 * Created by Looney on 2017/12/19.
 * Des:
 */

public class MainActivity extends BasedActivity {
    //DiskLruCache
    private final String TAG = this.getClass().getSimpleName();
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        StatusBarCompat.compat(binding.statusbar);

        setSupportActionBar(binding.toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        RoomFragment roomFragment = new RoomFragment();
        StudentFragment studentFragment = new StudentFragment();
        ZongheFragment zongheFragment = new ZongheFragment();
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(roomFragment, "roomFragment");
        adapter.addFragment(studentFragment, "studentFragment");
        adapter.addFragment(zongheFragment, "zongheFragment");


        binding.viewpager.setAdapter(adapter);
        binding.segmentedGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio0:
                        binding.viewpager.setCurrentItem(0);
                        break;
                    case R.id.radio1:
                        binding.viewpager.setCurrentItem(1);
                        break;
                    case R.id.radio2:
                        binding.viewpager.setCurrentItem(2);

                        break;
                }
            }
        });
        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0)
                    binding.radio0.setChecked(true);
                else if (position == 1)
                    binding.radio1.setChecked(true);
                else if (position == 2) {
                    binding.radio2.setChecked(true);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {

        }
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
