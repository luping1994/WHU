package net.suntrans.whu.core.manager;

import net.suntrans.whu.bean.Student;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Looney on 2017/12/21.
 * Des:
 */

public interface StudentDataSource {
    Flowable<List<Student>> getStudent();
}
