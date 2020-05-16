package syn;



public class DeadLock extends Thread {
    static  A a = new A();
    static  B b = new B();

    boolean flag ;

    public DeadLock(boolean flag) {
        this.flag = flag;
    }


    public void run(){
        if(flag)
        synchronized (a){
            System.out.println("锁定了a");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println("又锁定了b");
                System.out.println("开始执行");
            }
        }else{
            synchronized (b){
                System.out.println("锁定了b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("又锁定了a");
                    System.out.println("开始执行");
                }
            }
        }

    }



    public static void main(String[] args) {
        new DeadLock(true).start();
        new DeadLock(false).start();
    }

}

class  A{

}
class B{

}