package com.example.lycutter.handlertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends Activity {


    private TextView tv_count;
    private static int count = 5;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        tv_count = findViewById(R.id.tv_count);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    tv_count.setText(String.valueOf(count--));
                    System.out.println("count ====== " + count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }

            }
        }).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FirstActivity.this, SplashActivity.class));
            }
        }, 5000);

    }

    public void onStop() {
        System.out.println("初始Activity onStop");
        super.onStop();
        finish();
    }

    public void onDestroy() {
        System.out.println("初始Activity onDestroy");
        super.onDestroy();
    }


}
