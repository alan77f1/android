package com.android.cau2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    Button btnDraw ;
    Handler handler;
    EditText editNumb;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btnDraw = findViewById(R.id.btnDraw);
        editNumb = findViewById(R.id.editNumb);
        layout = findViewById(R.id.layout);

        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i= 0; i < Integer.valueOf( editNumb.getText().toString()); i++){
                            Message msg = new Message();

                            if (i%2==0){
                                msg.what = 1;

                            }else {
                                msg.what = 2;

                            }
                            handler.sendMessage(msg);
                        }
                    }
                });
                thread.start();
            }
        });

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                int ran1 = new Random().nextInt(10);
                int ran2 = new Random().nextInt(10);
                switch (msg.what){
                    case 1:
                        LinearLayout layout1 = new LinearLayout(MainActivity4.this);
                        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                        params1.topMargin = 20;
                        layout1.setLayoutParams(params1);
                        layout1.setOrientation(LinearLayout.HORIZONTAL);
                        layout1.setWeightSum(3);
                        layout.addView(layout1);

                        Button btn1 = new Button(MainActivity4.this);
                        btn1.setText(String.valueOf(ran1));
                        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
                        btn1.setLayoutParams(params2);
                        if (ran1 %2==0){ btn1.setBackgroundTintList(MainActivity4.this.getResources().getColorStateList(R.color.teal_200));}

                        Button btn2 = new Button(MainActivity4.this);
                        btn2.setText(String.valueOf(ran2));
                        LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,2.0f);
                        btn2.setLayoutParams(params3);
                        if (ran2 %2==0){ btn2.setBackgroundTintList(MainActivity4.this.getResources().getColorStateList(R.color.teal_200));}

                        layout1.addView(btn1);
                        layout1.addView(btn2);
                        break;

                    case 2:

                        LinearLayout layout2 = new LinearLayout(MainActivity4.this);
                        LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                        params4.topMargin = 20;
                        layout2.setLayoutParams(params4);
                        layout2.setOrientation(LinearLayout.HORIZONTAL);
                        layout2.setWeightSum(3);
                        layout.addView(layout2);

                        Button btn3 = new Button(MainActivity4.this);
                        btn3.setText(String.valueOf(ran1));
                        LinearLayout.LayoutParams params5 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,2.0f);
                        btn3.setLayoutParams(params5);
                        if (ran1 %2==0){ btn3.setBackgroundTintList(MainActivity4.this.getResources().getColorStateList(R.color.teal_200));}

                        Button btn4 = new Button(MainActivity4.this);
                        btn4.setText(String.valueOf(ran2));
                        LinearLayout.LayoutParams params6 = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1.0f);
                        btn4.setLayoutParams(params6);
                        if (ran2 %2==0){ btn4.setBackgroundTintList(MainActivity4.this.getResources().getColorStateList(R.color.teal_200));}

                        layout2.addView(btn3);
                        layout2.addView(btn4);


                        layout.addView(layout2);
                        break;
                }
                return true;
            }
        });
    }
}