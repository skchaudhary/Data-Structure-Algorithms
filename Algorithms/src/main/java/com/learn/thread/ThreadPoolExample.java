package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=1;i<=10;i++){
            Runnable worker = new WorkerThread("" +i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated());
        System.out.println("Finished all threads");
    }
}
class WorkerThread implements Runnable {
    String command;
    WorkerThread(String s){
        this.command = s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Started. command = "+command);
        processThread();
        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private void processThread() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
