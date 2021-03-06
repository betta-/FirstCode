package com.example.administrator.mapleone.modle;

import android.content.Context;

import com.example.administrator.mapleone.activity.MyLongClickImpActivity;
import com.example.administrator.mapleone.utils.Myshow;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class MyLongClickModleImp implements MyLongClickModle {
    private static final String TAG = "MyLongClickModleImp";
    private boolean isRuns = false;
    private static MyLongClickModleImp instance;
    Thread myUpThread = new Thread(new MyUpThread());
    Thread myDownThread = new Thread(new MyDownThread());

    public static MyLongClickModleImp getInstance(Context context) {
        if (instance == null) {
            instance = new MyLongClickModleImp();
        }
        return instance;
    }

    @Override
    public void isRunClick(boolean isRun) {
        this.isRuns = isRun;
    }

    @Override
    public void myClickUp() {
        new Thread(new MyUpThread()).start();
//        myUpThread.start();
    }

    @Override
    public void myClickDown() {
        new Thread(new MyDownThread()).start();
//        myDownThread.start();
    }

    @Override
    public void checkIsAlive() {
        if(myUpThread.isAlive()||myDownThread.isAlive()){
            Myshow.d(TAG, "-------------------------我还活着！！！" );
        }else{
            Myshow.d(TAG, "-------------------------死了" );
        }
    }

    class MyUpThread implements Runnable {

        @Override
        public void run() {
            while (isRuns) {
                try {
                    MyLongClickImpActivity.DAXIAO += 10;
                    Myshow.d(TAG, "-------------------------MyLongClickImpActivity.DAXIAO" + MyLongClickImpActivity
                            .DAXIAO);
                    sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();// 异常处理
                    throw new RuntimeException(e);
                }

            }
        }
    }

    class MyDownThread implements Runnable {

        @Override
        public void run() {
            while (isRuns) {
                try {
                    MyLongClickImpActivity.DAXIAO -= 10;
                    Myshow.d(TAG, "-------------------------MyLongClickImpActivity.DAXIAO" + MyLongClickImpActivity
                            .DAXIAO);
                    sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();// 异常处理
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
