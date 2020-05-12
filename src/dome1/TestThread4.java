package dome1;

//多个线程同时操作同一个对象
//多个线程操作同一个资源的情况下数据不安全
public class TestThread4 implements  Runnable{

    private   int ticketNum = 1000;
    //
    @Override
    public  void run() {
        while (true) {
            if (ticketNum <= 0) break;
            System.out.println(Thread.currentThread().getName() + "--拿到了--" + ticketNum--);
//          try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

     public static void main(String[] args) {
         TestThread4 testThread4 = new TestThread4();
         new Thread(testThread4,"bin").start();
         new Thread(testThread4,"飞鸿").start();
         new Thread(testThread4,"敏敏").start();
     }
}
