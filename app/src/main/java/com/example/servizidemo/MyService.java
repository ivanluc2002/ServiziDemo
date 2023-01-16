package com.example.servizidemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public static boolean isRunning= false;
    private int count= 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRunning  = true;
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (isRunning){
                            count++;
                            Log.e("myservice", "run: "+count );
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning=false;
        count=0;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
