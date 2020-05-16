package syn;

import java.util.concurrent.CopyOnWriteArrayList;
//测试JUC安全类型的集合
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                arrayList.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrayList.size());
    }
}
