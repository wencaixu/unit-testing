package com.wencaixu.test.thread;

import org.junit.Test;
import org.junit.internal.runners.statements.RunAfters;


public class JunitThreadTest {

    static class Sleep implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            while(true){
                synchronized (Wait.class){
                    try {
                        Wait.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Block implements Runnable{
        @Override
        public void run() {
            synchronized (Block.class){
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Sleep()).start();
        new Thread(new Wait()).start();
        new Thread(new Block(),"block-thread-1").start();
        new Thread(new Block(),"block-thread-2").start();
    }

}