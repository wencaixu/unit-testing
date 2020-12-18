package com.wencaixu.test.thread;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程的实现方式
 *
 * @Author wencai.xu
 * @Date 2020/12/12,0012
 * @Version V1.0
 **/
public class JunitThreadImpTest {

    /**
     * 多线程实现方式
     */
    @Test
    public void testThreadTest(){
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Test
    public void testRunnableTest(){
        MyThreadRun myThreadRun = new MyThreadRun();
        Thread thread = new Thread(myThreadRun);
        thread.start();
    }

    @Test
    public void testReturnTest() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future> futures = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Callable<Integer> callable = new MyRetureThread();
            Future submit = pool.submit(callable);
            futures.add(submit);
        }

        pool.shutdown();

        for(Future future : futures){
            System.out.println(future.get().toString());
        }
    }

    @Test
    public void testThreadPool(){

    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("继承Thread实现多线程");
        }
    }

    static class MyThreadRun implements Runnable{
        @Override
        public void run() {
            System.out.println("实现Runnable接口实现多线程");
        }
    }

    static class MyRetureThread implements Callable<Integer>{
        @Override
        public Integer call() {
            int s = 0;
            for(int i = 0; i < 10; i++){
                s += i;
            }
            return s;
        }
    }
}
