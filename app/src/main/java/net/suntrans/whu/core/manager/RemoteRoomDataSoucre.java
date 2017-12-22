package net.suntrans.whu.core.manager;

import net.suntrans.whu.bean.Room;
import net.suntrans.whu.netapi.Api;
import net.suntrans.whu.netapi.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public class RemoteRoomDataSoucre implements RoomDataSource {

    private Api api;

    public RemoteRoomDataSoucre() {
        this.api = RetrofitHelper.getApi();
    }

    @Override
    public Flowable<List<Room>> getRoom() {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Room room = new Room();
            rooms.add(room);
        }
        return Flowable.fromArray(rooms);
    }
}
