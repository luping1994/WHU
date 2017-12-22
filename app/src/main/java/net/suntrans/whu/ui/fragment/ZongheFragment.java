package net.suntrans.whu.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.suntrans.whu.R;
import net.suntrans.whu.databinding.FragmentZongheBinding;

public class ZongheFragment extends Fragment {

    private FragmentZongheBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zonghe,container,false);
        return binding.getRoot();
    }


}
