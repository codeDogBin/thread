package state;
//线程优先级
public class TestPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        TestPriority testPriority = new TestPriority();
        Thread thread1 = new Thread(testPriority);
        Thread thread2 = new Thread(testPriority);
        Thread thread3 = new Thread(testPriority);
        Thread thread4 = new Thread(testPriority);
        Thread thread5 = new Thread(testPriority);
        Thread thread6 = new Thread(testPriority);

        thread1.start();

        thread2.setPriority(1);
        thread3.setPriority(4);
        thread4.setPriority(7);
        thread5.setPriority(10);
//        thread6.setPriority(-1); 会报错 java.lang.IllegalArgumentException
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

    }
}
