package com.company;

import java.util.Deque;
import java.util.LinkedList;

class Main {

    public static void main(String args[]) {
        final Deque<Integer> queue = new LinkedList<Integer>();

        new Thread(new Consumer(1, queue)).start();
        new Thread(new Consumer(2, queue)).start();
        new Thread(new Consumer(3, queue)).start();

        new Thread(new Producer(11, queue)).start();
        new Thread(new Producer(12, queue)).start();
        new Thread(new Producer(13, queue)).start();
    }
}