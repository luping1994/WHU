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
import net.suntrans.whu.bean.Student;
import net.suntrans.whu.databinding.FragmentRoomBinding;
import net.suntrans.whu.databinding.FragmentStuBinding;
import net.suntrans.whu.ui.BasedFragment;
import net.suntrans.whu.ui.viewmodel.RoomViewModel;
import net.suntrans.whu.ui.viewmodel.StudentViewModel;
import net.suntrans.whu.ui.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by Looney on 2017/12/20
 * 管理员页面所有学生概况
 */
public class StudentFragment extends BasedFragment {

    private FragmentStuBinding binding;

    private ViewModelFactory mViewModelFactory;

    private StudentViewModel mViewModel;

    public static List<Student> stuDatas = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stu, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mViewModelFactory = new ViewModelFactory();
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(StudentViewModel.class);
        adapter = new MyAdapter(R.layout.item_student,stuDatas);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        binding.recyclerView.setAdapter(adapter);
    }


    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    private void getData() {
        mDisposable.add(mViewModel.getStus()
                .subscribe(new Consumer<List<Student>>() {
                    @Override
                    public void accept(List<Student> students) throws Exception {
                        stuDatas.clear();
                        stuDatas.addAll(students);
                        adapter.notifyDataSetChanged();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }

    private void getStuMenuData() {

    }

    class MyAdapter extends BaseQuickAdapter<Student, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<Student> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Student item) {

        }
    }
}
