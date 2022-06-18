package com.android.cau2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    Button btnDrawView;
    EditText editText;
    LinearLayout layoutContain,layoutContain2,layoutContain3,layoutContain4;
    Handler handler;
    private static final int DRAW_BUTTON = 1000;
    private static final int DRAW_DONE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        linkView();
        addEvent();
        initHandler();


    }
    private void linkView(){
        btnDrawView = findViewById(R.id.btnDraw);
        editText = findViewById(R.id.editNumb);
        layoutContain = findViewById(R.id.layoutContain1);
        layoutContain2 = findViewById(R.id.layoutContain2);
        layoutContain3 = findViewById(R.id.layoutContain3);
        layoutContain4 = findViewById(R.id.layoutContain4);
    }
    private  void addEvent(){
        btnDrawView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutContain.removeAllViews();
                layoutContain2.removeAllViews();
                layoutContain3.removeAllViews();
                layoutContain4.removeAllViews();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for ( int i = 1 ; i <= 12 ; i++){
                            Message msg = new Message();

                            if(i == 10){
                                msg.what = DRAW_BUTTON;
                                msg.arg1 = i;
                                msg.obj = "*";
                            }
                            else if(i == 11){
                                msg.what = DRAW_BUTTON;
                                msg.arg1 = i;
                                msg.obj = "0";
                            }
                            else if(i == 12){
                                msg.what = DRAW_BUTTON;
                                msg.arg1 = i;
                                msg.obj = "#";
                            }

                            else {
                                msg.what = DRAW_BUTTON;
                                msg.arg1 = i;
                                msg.obj = String.valueOf(i);
                            }
                            handler.sendMessage(msg);
                        }
                        handler.sendEmptyMessage(DRAW_DONE);
                    }
                });
                thread.start();
            }
        });
    }

    private  void initHandler(){

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case DRAW_BUTTON:
                        Button btnNumb = new Button(MainActivity1.this);
                        btnNumb.setText((String)msg.obj);
                        if(msg.arg1 >= 1 && msg.arg1 <= 3){
                            layoutContain.addView(btnNumb);
                        }else if(msg.arg1 >= 4 && msg.arg1 <= 6){
                            layoutContain2.addView(btnNumb);
                        }else if(msg.arg1 >= 7 && msg.arg1 <= 9){
                            layoutContain3.addView(btnNumb);
                        }else if(msg.arg1 >= 10 && msg.arg1 <= 12){
                            layoutContain4.addView(btnNumb);
                        }
                        btnNumb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String content = editText.getText().toString() + btnNumb.getText().toString();
                                editText.setText(content);
                            }
                        });
                        break;
                    case DRAW_DONE:
                        Toast.makeText(MainActivity1.this,"Done",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        };
    }

}
