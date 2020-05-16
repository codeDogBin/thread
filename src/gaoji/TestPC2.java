package gaoji;

public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者 演员
class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }
    public void run(){
        for (int i = 0; i < 100 ; i++) {
            if(i%2 == 0){
                tv.play("快手");
            }else{
                tv.play("抖音");
            }
        }

    }
}

//消费者 观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }
    public void run(){
        for (int i = 0; i < 100 ; i++) {
            tv.watch();
        }
    }

}
//产品 节目
class TV {
    //演员表演,观众等待
    //观众观看,演员等待
    String voice;  //表演节目
    boolean flag = true;//标志位

    public synchronized  void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了:"+voice);
        //通知观众观看
        this.notifyAll();
        this.voice= voice;
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了:"+voice);
        //通知观众观看
        this.notifyAll();
        this.voice= "";
        this.flag = !this.flag;
    }
}