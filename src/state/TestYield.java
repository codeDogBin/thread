package state;

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
}

public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"帅斌").start();
        new Thread(myYield,"陈祥").start();
    }

}
