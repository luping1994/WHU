package net.suntrans.whu.core.manager;

import net.suntrans.whu.bean.Room;
import net.suntrans.whu.bean.Student;
import net.suntrans.whu.netapi.Api;
import net.suntrans.whu.netapi.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public class RemoteStudentDataSoucre implements StudentDataSource {

    private Api api;

    public RemoteStudentDataSoucre() {
        this.api = RetrofitHelper.getApi();
    }

    @Override
    public Flowable<List<Student>> getStudent() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student room = new Student();
            students.add(room);
        }
        return Flowable.fromArray(students);
    }
}
