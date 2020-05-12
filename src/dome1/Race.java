package dome1;

public class Race implements Runnable {
    private String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100 ; i++) {
            if(Thread.currentThread().getName().equals("兔子")){//如果是兔子
                if(i%10==0){//如果是10 则线程休息下
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else i++;//否则多走一步 即两倍的速度
            }

            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
            Boolean win = win(i);
            if (win)break;
        }
    }

    public Boolean win(int length){
        if(length >= 100){
            winner = Thread.currentThread().getName();
            System.out.println(winner+"是胜利者");
            return true;
        }else if(winner !=null )return true;//如果存在胜利者则返回true
        else return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
