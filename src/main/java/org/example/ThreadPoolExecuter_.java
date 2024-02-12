package org.example;

import java.util.concurrent.*;

public class ThreadPoolExecuter_ {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(1), new CustomThreadFactory(), new CustomRejectionHandler());
        for(int i=0; i<=10;i++){
            int finalI = i;
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task "+ finalI + " "+Thread.currentThread().getName());
            });
        }
    }

}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);
        return thread;
    }
}

class CustomRejectionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected by execution handler : "+ r.toString() + executor.toString());
    }
}
