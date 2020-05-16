package state;



//模拟网络延时
public class TestSleep implements Runnable {
    private  int ticketNum = 1000;

    @Override
    public  void run() {
        while (true) {
          if (ticketNum <= 0) break;
          //模拟网络延时
          try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          System.out.println(Thread.currentThread().getName() + "--拿到了-->" + ticketNum--);
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep,"小斌").start();
        new Thread(testSleep,"飞鸿").start();
        new Thread(testSleep,"敏敏").start();
        new Thread(testSleep,"小宜").start();
        new Thread(testSleep,"灰灰").start();
        new Thread(testSleep,"混混").start();
    }
}
