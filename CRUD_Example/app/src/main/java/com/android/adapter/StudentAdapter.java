package com.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.cau2.MainActivity;
import com.android.cau2.R;
import com.android.model.Student;

import java.util.ArrayList;
import java.util.List;


public class StudentAdapter extends BaseAdapter {

//    public class StudentAdapter extends BaseAdapter {
//
//    private MainActivity context;
//    private int layout;
//    private ArrayList<Student> listStudent;
//
//    public StudentAdapter(MainActivity context, int layout, ArrayList<Student> listStudent) {
//        this.context = context;
//        this.layout = layout;
//        this.listStudent = listStudent;
//    }
//
//    @Override
//    public int getCount() {
//        return listStudent.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return listStudent.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder viewHolder;
//        if(view == null) {
//            viewHolder = new ViewHolder();
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(layout, null);
//            viewHolder.txtName = view.findViewById(R.id.txtName);
//            viewHolder.txtClass = view.findViewById(R.id.txtClass);
//            viewHolder.txtPoint = view.findViewById(R.id.txtPoint);
//            view.setTag(viewHolder);
//
//
//        }else{
//            viewHolder = (ViewHolder) view.getTag();
//        }
//        final Student s = listStudent.get(i);
//        viewHolder.txtName.setText("Ho ten sinh vien: " + s.getStudentName());
//        viewHolder.txtClass.setText("Lop: " + s.getStudentClass());
//        viewHolder.txtPoint.setText("Diem: " + s.getStudentPoint());
//
//
//        return view;
//    }
//
//    public static class ViewHolder {
//        TextView txtName, txtClass, txtPoint;
//    }


    public StudentAdapter(MainActivity context, int layout, ArrayList<Student> listStudent) {
        this.context = context;
        this.layout = layout;
        this.listStudent = listStudent;
    }

    private MainActivity context;
    private int layout;
    private ArrayList<Student> listStudent;


    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int i) {
        return listStudent.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.txtName = view.findViewById(R.id.txtName);
            viewHolder.txtClass = view.findViewById(R.id.txtClass);
            viewHolder.txtPoint = view.findViewById(R.id.txtPoint);
            view.setTag(viewHolder);


        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Student s = listStudent.get(i);
        viewHolder.txtName.setText("Ho va ten sinh vien: " + s.getStudentName());
        viewHolder.txtName.setText("Lop: " + s.getStudentClass());
        viewHolder.txtName.setText("Diem: " + s.getStudentPoint());

        return view;
    }


    public static class ViewHolder{
        TextView txtName, txtClass, txtPoint;
    }
}
