package state;



class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 365; i++) {
            System.out.println("人要快乐地活着"+i);
        }
    }
}
class God implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("上帝保佑你");
        }
    }
}


///测试守护线层
public class TestDaemon {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread thread1 = new Thread(you);
        Thread thread2 = new Thread(god);
        //设置守护线程
        thread2.setDaemon(true);
        thread2.start();
        thread1.start();
    }
}

