package net.suntrans.whu.ui;

import android.support.v4.app.Fragment;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Looney on 2017/12/20.
 * Des:
 */

public class BasedFragment extends Fragment {
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    public void onStop() {
        super.onStop();
        mDisposable.clear();
    }
}
