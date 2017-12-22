package net.suntrans.whu.ui.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import net.suntrans.whu.core.manager.RemoteRoomDataSoucre;
import net.suntrans.whu.core.manager.RemoteStudentDataSoucre;
import net.suntrans.whu.core.manager.RoomDataSource;
import net.suntrans.whu.core.manager.StudentDataSource;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public class ViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(RoomViewModel.class)) {
            RoomDataSource mDataSource = new RemoteRoomDataSoucre();
            return (T) new RoomViewModel(mDataSource);
        }
        if (modelClass.isAssignableFrom(StudentViewModel.class)) {
            StudentDataSource mDataSource = new RemoteStudentDataSoucre();
            return (T) new StudentViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
