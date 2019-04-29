package com.example.lycutter.handlertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_toUI;
    private Button btn_toSub;
    private Button btn_toCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btn_toUI = findViewById(R.id.toUIThread);
        btn_toSub = findViewById(R.id.toSubThread);
        btn_toCallback = findViewById(R.id.toHandlerCallback);
        btn_toUI.setOnClickListener(this);
        btn_toSub.setOnClickListener(this);
        btn_toCallback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.toUIThread: {
                Intent intent = new Intent(SplashActivity.this, InUIThread.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.toSubThread: {
                Intent intent = new Intent(SplashActivity.this, InSubThread.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.toHandlerCallback: {
                Intent intent = new Intent(SplashActivity.this, HandlerCallback.class);
                startActivity(intent);
                finish();
                break;
            }
            default:
                break;
        }
    }
}
