import java.util.Random;
import java.util.Scanner;

public class randomgame {
    public static void main(String[] args) {
        //需求：开发一个幸运小游戏，游戏规则如下：
        //游戏后台随机生成1-20之间的5个数（无所谓是否重复），然后让大家来猜数字：
        /*
            未猜中提示：“未命中”，并继续猜测
            猜中提示：“运气不错，猜中了”，并输出改数据第一次出现的位置，且输出全部五个数据，最终结束本游戏
         */

        //1、定义一个动态初始化的数组，存储五个随机的1-20之间的数据
        int[] data = new int[5];

        //2、动态的生成五个1-20之间的随机数并存入到数组中去
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(20)+1;
        }

        //3、使用一个死循环让用户进行猜测
        Scanner sc = new Scanner(System.in);
        OUT:
        while (true){
            System.out.println("请您输入一个1-20之间的整数进行猜测：");
            int guessData = sc.nextInt();

            //4、遍历数组中的每个数据，看是否有数据与猜测的数据相同，相同的代表中了，给出提示
            for (int i = 0; i < data.length; i++) {
                if(data[i] == guessData){
                    System.out.println("您已经猜中了该数据，运气不错！您猜中的数据的索引是："+ i);
                    break OUT;
                }
            }
            System.out.println("当前猜测的数据在数组中不存在，请重新猜测");
        }
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+"\t");
        }
    }
}
