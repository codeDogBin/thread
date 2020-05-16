package gaoji;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThreads().start();
        new Thread(new MyRunnable()).start();
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);
    }


}
class MyThreads extends Thread{
    @Override
    public void run() {
        System.out.println("thread线程方式");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("runnable线程方式");
    }
}
class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("callable线程方式");
        return "yes";
    }
}