package syn;

//账户
class Accunt{
    int  money;
    String name;

    public Accunt(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行模拟取款
class Drawing extends Thread {
    //账户
    Accunt accunt;
    //取出的钱
    int drawingMoney;
    //现在有的钱
    int nowMoney;

    boolean flag = true;

    public Drawing(Accunt accunt, int drawingMoney, int nowMoney,String name) {
        super(name);
        this.accunt = accunt;
        this.drawingMoney = drawingMoney;
        this.nowMoney = nowMoney;
    }

    @Override
    public void run() {
        //判断有没有钱
        while (flag){
            draw();
        }
    }
    private void draw(){
        synchronized (Accunt.class) {
            if (accunt.money - drawingMoney < 0) {
                System.out.println("钱不够,取不了");
                flag = false;
                return;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额-取出的钱
            accunt.money = accunt.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;
            System.out.println(accunt.name + "余额为" + accunt.money);
            //this.getName = Thread.currentThread().getName()
            System.out.println(this.getName() + "手里的钱:" + nowMoney);
        }
    }
}



public class UnsafeBank {
    public static void main(String[] args) {
        Accunt accunt = new Accunt(1000000,"灰灰的银行卡");

        Drawing drawing1 = new Drawing(accunt,1000,0,"小斌");
        Drawing drawing2 = new Drawing(accunt,500,50000,"灰灰");
        Drawing drawing3 = new Drawing(accunt,800,10000,"飞鸿");
        Drawing drawing4 = new Drawing(accunt,300,100000,"宋世奇");

        drawing1.start();
        drawing2.start();
        drawing3.start();
        drawing4.start();
    }
}
