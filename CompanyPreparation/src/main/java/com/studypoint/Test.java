package com.studypoint;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=100;i++){
                    System.out.println(i);
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=101;i<=200;i++){
                    System.out.println(i);
                }
            }
        });
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.shutdown();
    }
}
