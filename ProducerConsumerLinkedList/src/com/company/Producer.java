package com.company;

import java.util.Deque;
import java.util.Random;

class Producer implements Runnable {

    private final Deque queue;
    private final int tid;
    private Random rand = new Random();

    Producer(int id, Deque dq) {
        queue = dq;
        tid = id;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int num = rand.nextInt(1000); // random integer 0-1000
                synchronized (queue) {
                    queue.offer(num);
                    queue.notify();
                }
                System.out.println(
                        "Producer:" + tid + " sleep:" + (num + 2000));
                Thread.sleep(num + 2000);  // pause for 2-3 seconds
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}