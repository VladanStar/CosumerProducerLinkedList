package com.company;

import java.util.Deque;

class Consumer implements Runnable {

    private final Deque queue;
    private final int tid;

    Consumer(int id, Deque dq) {
        queue = dq;
        tid = id;
    }

    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    while (queue.peek() == null) {
                        queue.wait();
                    }
                    System.out.println(
                            "Consumer:" + tid + " output:" + queue.poll());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
