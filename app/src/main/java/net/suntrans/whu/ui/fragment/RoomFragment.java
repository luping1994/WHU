package net.suntrans.whu.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.suntrans.whu.R;
import net.suntrans.whu.ui.BasedFragment;

/**
 * Created by Looney on 2017/12/20
 * 管理员页面所有房间概况
 */
public class RoomFragment extends BasedFragment {


    public RoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room, container, false);
    }

}
