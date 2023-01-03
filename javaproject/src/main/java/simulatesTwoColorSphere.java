import java.util.Random;
import java.util.Scanner;

public class simulatesTwoColorSphere {
    /*
    双色球系统-业务分析、随机生成一组中奖号码
    投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1-33中选择；蓝色球号码从1-16中选择。
    一等奖     最高1000万     中6+1
    二等奖     最高500万      中6+0
    三等奖     3000          中5+1
    四等奖     200           中5+0或4+1
    五等奖     10元           中4+0或3+1
    六等奖     5元            中2+1或1+1或0+1
    1、随机一组中奖号码返回
    2、用户输入一组双色球号码返回
        定义一个方法，该方法可以录入用户输入的6个红球和1个蓝球号码
        该方法最终需要返回一个数组，数组中就是用户录入的号码（7位）
    3、传入两组号码，判断用户中奖情况
        定义一个方法，可以接收中奖号码的数组，用户选好的数组
        根据命中红球数和蓝球数判断最终的中奖情况并输出详情和中奖金额
     */
    public static void main(String[] args) {
        //1、随机6个红色号码（1-33，不能重复），随机一个篮球号码（1-16），可以采用数组装起来作为中奖号码
        int[] luckNumbers = createLuckNumber();
        //printArray(luckNumbers);
        //2、用户输入一组双色球号码返回
        int[] userNumbers = userInputNumbers();
        //printArray(userNumbers);
        //3、传入两组号码，判断用户中奖情况
        judge(luckNumbers, userNumbers);
    }

    //打印数组
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();//换行
    }

    //1、随机一组中奖号码返回
    public static int[] createLuckNumber() {
        //a.定义一个动态初始化的数组，存储7个数字
        int[] numbers = new int[7];
        //b.遍历数组，为每个位置生成对应的号码
        Random r = new Random();
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                int data = r.nextInt(33) + 1;
                //c、注意：必须判断当前随机的这个号码之前是否出现过，出现过要重新随机一个，知道不重复为止，才可以存入数组中去
                //定义一个flag变量，默认认为data是没有重复的
                boolean flag = true;
                for (int j = 0; j < i; j++) {
                    if (numbers[j] == data) {
                        //data当前这个数据之前出现过，不能用
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    //data这个数据之前没有出现过，可以使用了
                    numbers[i] = data;
                    break;
                }
            }

        }
        //d、为第七个为之生成一个1-15的号码作为蓝球号码
        numbers[numbers.length - 1] = r.nextInt(16) + 1;
        return numbers;
    }

    //2、用户输入一组双色球号码返回
    public static int[] userInputNumbers() {
        //a、定义一个数组，存储7个号码
        int[] numbers = new int[7];
        //b、让用户录入6个红球号码
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("请您输入第" + (i + 1) + "个红球号码(1-33,要求不重复）： ");
            int data = sc.nextInt();
            //c、把当前录入的数据存入到数组中去
            numbers[i] = data;
        }

        //单独录入一个蓝球号码
        System.out.println("请您输入蓝球号码（1-16）");
        numbers[6] = sc.nextInt();
        return numbers;
    }

    //3、传入两组号码，判断用户中奖情况
    public static void judge(int[] luckNumbers, int[] userNumbers) {
        //判断是否中奖了
        //luckNumbers = {12, 23, 8, 16, 15, 32,   9]
        //userNumbers = {13, 23, 8, 16, 15, 32,   9]
        //1、定义两个变量分别存储红球命中的个数，以及蓝球命中的个数
        int redHitNumbers = 0;
        int blueHitNumber = 0;

        //2、判断红球命中了几个，开始统计
        for (int i = 0; i < userNumbers.length - 1; i++) {
            for (int j = 0; j < luckNumbers.length - 1; j++) {
                //每次找到了相等的，意味着当前号码命中了
                if (userNumbers[i] == luckNumbers[j]) {
                    redHitNumbers++;
                    break;
                }
            }
        }

        //蓝球号码是否命中了
        blueHitNumber = luckNumbers[6] == userNumbers[6] ? 1 : 0;

        System.out.println("中奖号码是： ");
        printArray(luckNumbers);
        System.out.println("您投注号码是： ");
        printArray(userNumbers);
        System.out.println("您命中了" + redHitNumbers + "个红球，" + blueHitNumber + "个蓝球");
        //判断中奖情况
        if (blueHitNumber == 1 && redHitNumbers < 3) {
            System.out.println("恭喜你，中了5元小奖");
        } else if (blueHitNumber == 1 && redHitNumbers == 3 || blueHitNumber == 0 && redHitNumbers == 4) {
            System.out.println("恭喜你，中了10元小奖");
        } else if (blueHitNumber == 1 && redHitNumbers == 4 || blueHitNumber == 0 && redHitNumbers == 5) {
            System.out.println("恭喜你，中了200元");
        } else if (blueHitNumber == 1 && redHitNumbers == 5) {
            System.out.println("恭喜你，中了3000元");
        } else if (blueHitNumber == 0 && redHitNumbers == 6) {
            System.out.println("恭喜你，中了500万");
        } else if (blueHitNumber == 1 && redHitNumbers == 6) {
            System.out.println("恭喜你，中了1000万");
        } else {
            System.out.println("不好意思，没有中奖");
        }
    }
}
