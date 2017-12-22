package net.suntrans.whu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.suntrans.whu.core.db.AppDatabase;
import net.suntrans.whu.ui.BasedActivity;
import net.suntrans.whu.ui.LoginActivity;
import net.suntrans.whu.utils.UiUtils;

public class SplashActivity extends BasedActivity {

    private static final int MSG_START_LOGIN = 1;
    private static final int MSG_START_ADMIN_MAIN = 2;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_START_LOGIN:
                    break;
                case MSG_START_ADMIN_MAIN:
                    break;
            }
        }
    };
    private AppDatabase instance;

    private String sign = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent = getIntent();
        if (intent != null) {
            String m_sign = intent.getStringExtra("m_sign");
            if (m_sign != null) {
                sign = m_sign;
                UiUtils.showToast(m_sign);
            }
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                finish();
            }
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        handler.removeMessages(MSG_START_LOGIN);
        handler.removeMessages(MSG_START_ADMIN_MAIN);
        super.onDestroy();
    }


    public void share(String desc) {

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        shareIntent.putExtra(Intent.EXTRA_TEXT, sign);
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent, desc));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share) {
            share("分享");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
