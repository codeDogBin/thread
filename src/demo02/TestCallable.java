package demo02;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;
//下载类
class WebDownload{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class TestCallable implements Callable<Boolean> {


    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url,name);
        System.out.println(name+"下载完成");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable testThread1 = new TestCallable("https://img.tupianzj.com/uploads/allimg/202002/9999/04774be122.jpg","11.jpg");
        TestCallable testThread2 = new TestCallable("https://img.tupianzj.com/uploads/allimg/202002/9999/08b8d2520e.jpg","21.jpg");
        TestCallable testThread3 = new TestCallable("https://img.tupianzj.com/uploads/allimg/202002/9999/23fb60ee23.jpg","31.jpg");
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1 = service.submit(testThread1);
        Future<Boolean> result2 = service.submit(testThread2);
        Future<Boolean> result3 = service.submit(testThread3);
        //获取结果
        Boolean flag1 = result1.get();
        Boolean flag2 = result2.get();
        Boolean flag3 = result3.get();
        System.out.println("result1:"+flag1);
        System.out.println("result2:"+flag2);
        System.out.println("result3:"+flag3);
        //关闭服务
        service.shutdownNow();

    }
}

