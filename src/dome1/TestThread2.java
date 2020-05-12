package dome1;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//联系下载网络图片
public class TestThread2 extends Thread {
  private String url;
  private String name;
  public TestThread2(String url,String name){
      this.url=url;
      this.name=name;
  }
  public void run(){
      WebDownload webDownload = new WebDownload();
      webDownload.downloader(url,name);
      System.out.println(name+"下载完成");
  }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2("https://img.tupianzj.com/uploads/allimg/202002/9999/04774be122.jpg","1.jpg");
        TestThread2 testThread2 = new TestThread2("https://img.tupianzj.com/uploads/allimg/202002/9999/08b8d2520e.jpg","2.jpg");
        TestThread2 testThread3 = new TestThread2("https://img.tupianzj.com/uploads/allimg/202002/9999/23fb60ee23.jpg","3.jpg");
        testThread1.start();
        testThread2.start();
        testThread3.start();
    }


}
class WebDownload{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
