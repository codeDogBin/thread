package state;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestSleep2 {
    //倒计时
    public static void tenDown() throws InterruptedException {
        int num =10;
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num <= 0){
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        tenDown();

        //模拟时钟
        LocalTime localTime = LocalTime.now();
        while (true){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String format = localTime.format(dateTimeFormatter);
            Thread.sleep(1000);
            System.out.println(format);
            localTime = LocalTime.now();
        }
    }
}
