package net.suntrans.whu.ui.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import net.suntrans.whu.R;
import net.suntrans.whu.adapter.DividerItemDecoration;
import net.suntrans.whu.bean.Room;
import net.suntrans.whu.core.manager.RemoteRoomDataSoucre;
import net.suntrans.whu.core.manager.RoomDataSource;
import net.suntrans.whu.databinding.FragmentRoomBinding;
import net.suntrans.whu.netapi.BaseSubscriber;
import net.suntrans.whu.ui.BasedFragment;
import net.suntrans.whu.ui.viewmodel.RoomViewModel;
import net.suntrans.whu.ui.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Looney on 2017/12/20
 * 管理员页面所有房间概况
 */
public class RoomFragment extends BasedFragment {

    private FragmentRoomBinding binding;

    private ViewModelFactory mViewModelFactory;

    private RoomViewModel mViewModel;
    private final String[] status={"正常","恶性负载","电表锁定","等待"};   //电表状态数组

    public static List<Room> roomDatas = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_room, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViewModelFactory = new ViewModelFactory();
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(RoomViewModel.class);
        adapter = new MyAdapter(R.layout.item_room,roomDatas);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(adapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {
        mDisposable.add(mViewModel.getRoom()
                .subscribe(new Consumer<List<Room>>() {
                    @Override
                    public void accept(List<Room> rooms) throws Exception {
                        roomDatas.clear();
                        roomDatas.addAll(rooms);
                        adapter.notifyDataSetChanged();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }

    private void getRoomMenuData() {

    }

    class MyAdapter extends BaseQuickAdapter<Room, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<Room> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Room item) {

        }
    }
}
