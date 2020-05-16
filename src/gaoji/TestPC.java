package gaoji;

public class TestPC {
    public static void main(String[] args) {
        SynCache synCache = new SynCache();
        Customer customer1 = new Customer(synCache);
        Customer customer2 = new Customer(synCache);
        Producter producter = new Producter(synCache);
        producter.start();
        customer1.start();
        customer2.start();
    }

}
//消费者
class Customer extends Thread{
    SynCache synCache;

    public Customer(SynCache synCache){
        this.synCache = synCache;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chilken pop = synCache.pop();
            System.out.println("消费了第"+pop.id+"只鸡");
        }
    }
}
//生产者
class Producter extends  Thread{
    SynCache synCache;

    public Producter(SynCache synCache){
        this.synCache = synCache;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+i+"只鸡");
            Chilken chilken = new Chilken(i);
            synCache.push(chilken);
        }
    }
}


class Chilken{
    int id;

    public Chilken() {
    }

    public Chilken(int id) {
        this.id = id;
    }
}

//缓存区
class SynCache{

    //需要一个容器大小
    Chilken[] chilkens = new Chilken[10];
    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chilken chilken){
        //如果容器满了就需要等待消费者消费
        if(count == chilkens.length){
            //通知消费者消费 生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满.我们就需要丢入产品
        chilkens[count]= chilken;
        count++;

        //可以通知消费者消费
        this.notifyAll();
    }


    //消费者消费产品
    public synchronized Chilken pop(){
        //如果容器没有鸡
        if(count == 0){
            //通知生产者生产 消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Chilken chilken = chilkens[--count];
        //可以通知生产者生产
        this.notifyAll();
        return chilken;
    }



}
