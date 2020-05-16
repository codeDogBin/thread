package state;

public class TestState  {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);

        //观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED){
            Thread.sleep(200);
            state = thread.getState();
            System.out.println(state);
        }
    }

}
