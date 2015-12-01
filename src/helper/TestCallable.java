package helper;

import java.util.concurrent.*;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread());
                return "Hi, Maria";
            }
        };

        Runnable r = new Runnable() {
            @Override
            public void run()  {
                System.out.println(Thread.currentThread());
                System.out.println("Hi, Maria from runnable!");
            }
        };

        new Thread(r,"MyRunnable").start();


        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> submit = executor.submit(c);
        System.out.println(submit.isDone());

//        System.out.println(submit);
        System.out.println(Thread.currentThread());
        String s = submit.get();
        System.out.println(submit.isDone());
        System.out.println(s);

        executor.shutdown();
    }

}
