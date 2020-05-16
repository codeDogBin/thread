package gaoji;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();

    }

}

class TestLock2 implements Runnable{

    int ticketNum = 10;

    //定义lock锁

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try {
                lock.lock();
                if (ticketNum <= 0){
                    break;
                }else{
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                }
            } finally {
                lock.unlock();
            }

        }
    }
}