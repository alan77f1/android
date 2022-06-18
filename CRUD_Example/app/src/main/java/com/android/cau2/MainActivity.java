package com.android.cau2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.adapter.StudentAdapter;
import com.android.model.Student;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Databases databases;
    ListView lvData;
    ArrayList <Student> listStudent;
    StudentAdapter studentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkView();
//        initData();
        loadData();
        addEvent();
    }

    private void addEvent() {
    lvData.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

           final Dialog dialogDetail = new Dialog(MainActivity.this);
           // dialogDetail.setContentView(R.layout.layout_add);
            //dialogDetail.setContentView(R.layout.layout_delete);
            dialogDetail.setContentView(R.layout.layout_edit);


            final EditText editName = dialogDetail.findViewById(R.id.editName);
          final EditText editClass = dialogDetail.findViewById(R.id.editClass);
          final EditText editPoint = dialogDetail.findViewById(R.id.editPoint);
          Student s = listStudent.get(i);
          Button btnSave = dialogDetail.findViewById(R.id.btnSave);
          Button btnBack = dialogDetail.findViewById(R.id.btnBack);
            Button btnEdit = dialogDetail.findViewById(R.id.btnEdit);


            Button btnDelete = dialogDetail.findViewById(R.id.btnDelete);
          editName.setText(s.getStudentName());
          editClass.setText(s.getStudentClass());
          editPoint.setText(s.getStudentPoint().toString());


//          btnSave.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                  if(editName.getText().toString() == "" || editClass.getText().toString() == "" || editPoint.getText().toString() == ""){
//                      Toast.makeText(MainActivity.this, "Khong duoc de trong thong tin", Toast.LENGTH_LONG).show();
//                  }else {
//                      String saveName =editName.getText().toString();
//                      String saveClass = editClass.getText().toString();
//                      Float savePoint = Float.parseFloat(editPoint.getText().toString());
//                      databases.QueryData("INSERT INTO " + Databases.TBL_NAME + " VALUES( null, '"+saveName+"', '"+saveClass+"', "+savePoint+" )" );
//                      Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
//                      dialogDetail.dismiss();
//                      loadData();
//
//
//                  }
//              }
//          });

            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String newName = editName.getText().toString();
                    String newClass = editClass.getText().toString();
                    Float newPoint = Float.parseFloat(editPoint.getText().toString());
                    databases.QueryData("UPDATE " + Databases.TBL_NAME + " SET "+Databases.COL_NAME+ "= '"+newName+"' ,"+Databases.COL_CLASS+ "= '"+newClass+"', "+Databases.COL_POINT+ "= "+newPoint+" WHERE " +Databases.COL_ID+ "= " + s.getStudentId());
                    Toast.makeText(MainActivity.this, "Sua thanh cong", Toast.LENGTH_LONG).show();
                    dialogDetail.dismiss();
                    loadData();

                }
            });
//          btnDelete.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                  final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                  builder.setMessage("Ban co chac chan muon xoa khong");
//                  builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
//                      @Override
//                      public void onClick(DialogInterface dialogInterface, int i) {
//                            databases.QueryData("DELETE FROM " +Databases.TBL_NAME +" WHERE studentId = " + s.getStudentId());
//                          Toast.makeText(MainActivity.this, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
//                          loadData();
//                          dialogDetail.dismiss();
//                      }
//                  });
//                  builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
//                      @Override
//                      public void onClick(DialogInterface dialogInterface, int i) {
//
//                      }
//                  });
//                  builder.show();
//
//
//              }
//          });

            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialogDetail.dismiss();
                }

            });
           dialogDetail.show();
            return false;
        }
    });
    }

//    private void initData() {
//        databases = new Databases(this);
//        databases.createData();
//    }

    private void loadData() {
        String sql = "SELECT * FROM " + Databases.TBL_NAME;
        Cursor c = databases.GetData(sql);
         listStudent.clear();
       while (c.moveToNext()){
           String studentId = c.getString(0);
           String studentName = c.getString(1);
           String studentClass = c.getString(2);
           String studentPoint = c.getString(3);

           Student student = new Student(studentId, studentName,studentClass, studentPoint);
           listStudent.add(student);
       }
       studentAdapter.notifyDataSetChanged();

    }

    private void linkView() {
        lvData = findViewById(R.id.lvData);
        listStudent = new ArrayList<>();
        studentAdapter = new StudentAdapter(this, R.layout.item_row, listStudent);
        lvData.setAdapter(studentAdapter);
    }
}