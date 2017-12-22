package net.suntrans.whu.core.manager;

import net.suntrans.whu.bean.Room;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public interface RoomDataSource {
    Flowable<List<Room>> getRoom();
}
