package com.android.cau2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button btnDraw;
    EditText editNumb;
    LinearLayout layout;
    Handler handler;
    private final  int DRAW_BUTTON = 1000;
    private final  int DRAW_TEXTVIEW = 1001;
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
                                msg.what = DRAW_BUTTON;
                            }else {
                                msg.what = DRAW_TEXTVIEW;
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
                int random = new Random().nextInt(100);
                switch (msg.what){
                    case DRAW_BUTTON:
                        Button btn = new Button(MainActivity2.this);
                        btn.setText(String.valueOf(random));
                        layout.addView(btn);
                        break;
                    case DRAW_TEXTVIEW:
                        EditText txt2 = new EditText(MainActivity2.this);
                        txt2.setText(String.valueOf(random));
                        layout.addView(txt2);
                        break;
                }
                return true;
            }
        });
    }
}