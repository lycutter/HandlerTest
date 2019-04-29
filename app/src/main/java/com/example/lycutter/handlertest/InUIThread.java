package com.example.lycutter.handlertest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InUIThread extends Activity implements View.OnClickListener {
    private Button btn_thread1;
    private Button btn_thread2;
    private Button btn_thread3;
    private Button btn_thread4;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    private CostumHandler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new CostumHandler();

        btn_thread1 = findViewById(R.id.btn_thread1);
        btn_thread2 = findViewById(R.id.btn_thread2);
        btn_thread3 = findViewById(R.id.btn_thread3);
        btn_thread4 = findViewById(R.id.btn_thread4);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        btn_thread1.setOnClickListener(this);
        btn_thread2.setOnClickListener(this);
        btn_thread3.setOnClickListener(this);
        btn_thread4.setOnClickListener(this);


    }

//    @Override
//    public void onClick(View v) {
//        int btn_id = v.getId();
//        switch (btn_id) {
//            case R.id.btn_thread1: {
//                mHandler = new CostumHandler();
//                Message msg = mHandler.obtainMessage();
//                msg.what = 1;
//                msg.obj = new CostumObj("线程1");
//                mHandler.sendMessage(msg);
//
//                break;
//            }
//            case R.id.btn_thread2: {
//                mHandler = new CostumHandler();
//                Message msg = mHandler.obtainMessage();
//                msg.what = 2;
//                msg.obj = new CostumObj("线程2");
//                mHandler.sendMessage(msg);
//                break;
//            }
//            case R.id.btn_thread3: {
//                mHandler = new CostumHandler();
//                Message msg = mHandler.obtainMessage();
//                msg.what = 3;
//                msg.obj = new CostumObj("线程3");
//                mHandler.sendMessage(msg);
//                break;
//            }
//            case R.id.btn_thread4: {
//                mHandler = new CostumHandler();
//                Message msg = mHandler.obtainMessage();
//                msg.what = 4;
//                msg.obj = new CostumObj("线程4");
//                mHandler.sendMessage(msg);
//                break;
//            }
//
//            default:
//                break;
//        }
//    }

    @Override
    public void onClick(View v) {
        int btn_id = v.getId();
        switch (btn_id) {
            case R.id.btn_thread1: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CostumObj obj = new CostumObj("线程1");
                        mHandler.obtainMessage(1, obj).sendToTarget();
                        System.out.println("主线程id == " + Looper.getMainLooper().getThread().getId());
                        System.out.println("本线程id == " + Thread.currentThread().getId());
                    }
                }).start();

                break;
            }
            case R.id.btn_thread2: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CostumObj obj = new CostumObj("线程2");
                        mHandler.obtainMessage(2, obj).sendToTarget();
                        System.out.println("主线程id == " + Looper.getMainLooper().getThread().getId());
                        System.out.println("本线程id == " + Thread.currentThread().getId());
                    }
                }).start();

                break;
            }
            case R.id.btn_thread3: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CostumObj obj = new CostumObj("线程3");
                        mHandler.obtainMessage(3, obj).sendToTarget();
                        System.out.println("主线程id == " + Looper.getMainLooper().getThread().getId());
                        System.out.println("本线程id == " + Thread.currentThread().getId());
                    }
                }).start();

                break;
            }
            case R.id.btn_thread4: {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        CostumObj obj = new CostumObj("线程4");
                        mHandler.obtainMessage(4, obj).sendToTarget();
                        System.out.println("主线程id == " + Looper.getMainLooper().getThread().getId());
                        System.out.println("本线程id == " + Thread.currentThread().getId());
                    }
                }).start();

                break;
            }
            default:
                break;
        }
    }

    public class CostumHandler extends Handler {



        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            CostumObj costumObj = (CostumObj) msg.obj;
            String obj = costumObj.obj;

            switch (what) {
                case 1: {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        System.out.println("myLooper正在UI线程...........");
                    } else {
                        System.out.println("myLooper不在UI线程..........");
                    }

                    if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                        System.out.println("handler运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    } else {
                        System.out.println("handler不是运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    }

                    System.out.println("obj ===== " + obj);
                    tv1.setText("通过Handler更新UI-1");
                    break;
                }
                case 2: {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        System.out.println("myLooper正在UI线程...........");
                    } else {
                        System.out.println("myLooper不在UI线程..........");
                    }

                    if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                        System.out.println("handler运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    } else {
                        System.out.println("handler不是运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    }

                    System.out.println("obj ===== " + obj);
                    tv2.setText("通过Handler更新UI-2");
                    break;
                }

                case 3: {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        System.out.println("myLooper正在UI线程...........");
                    } else {
                        System.out.println("myLooper不在UI线程..........");
                    }

                    if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                        System.out.println("handler运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    } else {
                        System.out.println("handler不是运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    }

                    System.out.println("obj ===== " + obj);
                    tv3.setText("通过Handler更新UI-3");
                    break;
                }

                case 4: {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        System.out.println("myLooper正在UI线程...........");
                    } else {
                        System.out.println("myLooper不在UI线程..........");
                    }

                    if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId()) {
                        System.out.println("handler运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    } else {
                        System.out.println("handler不是运行在主线程, 当前线程id === " + Thread.currentThread().getId() );
                    }

                    System.out.println("obj ===== " + obj);
                    tv4.setText("通过Handler更新UI-4");
                    break;
                }

                default:
                    break;
            }
        }
    }

    public class CostumObj {

        String obj;

        public CostumObj (String obj) {
            this.obj = obj;
        }
    }
}
