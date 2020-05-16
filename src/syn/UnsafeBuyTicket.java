package syn;


class BuyTicket implements Runnable{

    //票
    private int ticketnum =10;
    boolean flag = true;

    @Override
    public void run() {
        while(flag) {
            buy();
        }

    }
    //买票的方法
    private synchronized void buy(){
        //判断是否还有票
        if(ticketnum <= 0){
            flag = false;
            return;
        }
        try {
            //增加延时 提高出错率
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"买到了第"+ticketnum--+"张票");
    }
}




//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"小斌").start();
        new Thread(buyTicket,"陈祥").start();
        new Thread(buyTicket,"灰灰").start();
        new Thread(buyTicket,"宋世奇").start();
    }
}
