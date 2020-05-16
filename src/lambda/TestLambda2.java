package lambda;



interface ILove {
    void love(int a);
}

class Love1 implements ILove {

    @Override
    public void love(int a) {
        System.out.println("love" + a);
    }
}

public class TestLambda2 {

    public static void main(String[] args) {
        ILove love1 = new Love1();
        love1.love(1);

        //1 lambda表达式简化
        ILove love2 = (int a) -> {
            System.out.println("love" + a);
        };
        //2 lambda表达式简化 去掉参数类型  多个参数的话可以都省略 一般情况下使用这个比较好
        ILove love3 = (a) -> {
            System.out.println("love" + a);
        };
        //3 lambda表达式简化 去掉参数括号 但是仅限一个参数
        ILove love4 = a -> {
            System.out.println("love" + a);
        };
        //4. lambda表达式简化 去掉花括号 但是只能有一行代码的情况下才行
        ILove love5 = a -> System.out.println("love" + a);


        love2.love(2);
        love3.love(3);
        love4.love(4);
        love5.love(5);

        //
    }

}
