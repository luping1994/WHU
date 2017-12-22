package net.suntrans.whu.ui.viewmodel;

import android.arch.lifecycle.ViewModel;

import net.suntrans.whu.bean.Room;
import net.suntrans.whu.core.manager.RoomDataSource;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public class RoomViewModel extends ViewModel {

    private final RoomDataSource mDataSource;

    public RoomViewModel(RoomDataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    public Flowable<List<Room>> getRoom(){
        return mDataSource.getRoom();
    }
}
