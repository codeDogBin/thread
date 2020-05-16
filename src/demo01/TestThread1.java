package demo01;
//创建线程方式1:继承Thread
public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 2000 ; i++) {
            System.out.println("我在敲代码---"+i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();
        testThread1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程---"+i);
        }

    }
}
