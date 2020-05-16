package lambda;


//1定义一个接口
interface ILook {
    void lambda();
}

//2实现类
class Look implements ILook {

    @Override
    public void lambda() {
        System.out.println("我是ILook");
    }
}

public class TestLambda1 {

    //3.静态内部类
    static class Look2 implements ILook {
        @Override
        public void lambda() {
            System.out.println("我是ILook2");
        }
    }


    public static void main(String[] args) {
        Look look = new Look();
        look.lambda();
        Look2 look2 = new Look2();
        look2.lambda();

        //4.局部内部类
        class Look3 implements ILook {
            @Override
            public void lambda() {
                System.out.println("我是ILook3");
            }
        }

        Look3 like3 = new Look3();
        like3.lambda();

        //5.匿名内部类
        ILook look4 = new ILook() {
            @Override
            public void lambda() {
                System.out.println("我是Ilook4");
            }
        };
        look4.lambda();

        //6用lambda
        ILook look5 = () -> {
            System.out.println("我是Ilook5");
        };

        look5.lambda();

    }

}

