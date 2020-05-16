package gaoji;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//测试线程池
public class TestPool {
    public static void main(String[] args) {
        //创建线程池
        //参数 设置线程池大小
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        {
            System.out.println(Thread.currentThread().getName());
        }
    }
}