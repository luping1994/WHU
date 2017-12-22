package net.suntrans.whu.ui.viewmodel;

import android.arch.lifecycle.ViewModel;

import net.suntrans.whu.bean.Room;
import net.suntrans.whu.bean.Student;
import net.suntrans.whu.core.manager.RoomDataSource;
import net.suntrans.whu.core.manager.StudentDataSource;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public class StudentViewModel extends ViewModel {

    private final StudentDataSource mDataSource;

    public StudentViewModel(StudentDataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    public Flowable<List<Student>> getStus(){
        return mDataSource.getStudent();
    }
}
