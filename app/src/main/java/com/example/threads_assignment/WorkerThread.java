package com.example.threads_assignment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class WorkerThread extends Thread {

    private android.os.Handler mainThreadHandler;

    public WorkerThread(Handler mainThreadHandler) {
        this.mainThreadHandler = mainThreadHandler;
    }

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        int progress = 0;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                progress = progress+10;
                Message message = Message.obtain();
                message.obj = progress;
                mainThreadHandler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Looper.loop();
    }

}
