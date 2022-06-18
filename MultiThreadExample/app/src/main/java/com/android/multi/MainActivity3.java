package com.android.cau2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    Button btnDraw;
    EditText editNumb;
    LinearLayout layout;
    Handler handler;
    private final  int DRAW_BUTTON1 = 1000;
    private final  int DRAW_BUTTON2 = 1001;

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
                        for (int i = 1 ; i <= Integer.parseInt(editNumb.getText().toString()); i++ ){
                            Message msg = new Message();
                            if( i % 2 == 0) {
                                msg.what = DRAW_BUTTON1;
                            }else {
                                msg.what = DRAW_BUTTON2;
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
                int ran = new Random().nextInt(100) ;
                switch (msg.what){
                    case DRAW_BUTTON1:
                        Button btn1 = new Button(MainActivity3.this);
                        btn1.setText( String.valueOf(ran));
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                        params.weight = 1.0f;
                        params.gravity = Gravity.LEFT;

                        btn1.setLayoutParams(params);
                        layout.addView(btn1);
                        break;

                    case DRAW_BUTTON2:
                        Button btn2 = new Button(MainActivity3.this);
                        btn2.setText( String.valueOf(ran));
                        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
                        params2.weight = 1.0f;
                        params2.gravity = Gravity.RIGHT;
                        btn2.setLayoutParams(params2);
                        layout.addView(btn2);
                        break;


                }
                return false;
            }
        });
    }
}
