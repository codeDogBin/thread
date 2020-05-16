package state;
//测试stop
//1.建议线程正常停止-->利用次数,不建议死循环
//2.建议使用标志位-->设置一个标志位
//.不要使用stop或则destroy等过时的方法
public class TestStop implements Runnable{
    private Boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("线程正在跑"+i++);
        }
    }

    public void stop(){
        this.flag= false;
        System.out.println("线程终止");
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程正在跑"+i);
            if(i==900){
                testStop.stop();
            }
        }
    }
}
