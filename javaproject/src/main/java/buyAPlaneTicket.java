import java.util.Scanner;

public class buyAPlaneTicket {
    /*
    需求：
        机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价，月份和头等舱或经济舱
        机票最终又会价格的计算方案如下：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折
    分析：
        键盘录入机票的原价，仓位类型，月份信息，调用方法返回机票最终的优惠价格
        方法内部应该先使用if分支判断月份是旺季还是淡季，然后使用switch分支判断是头等舱还是经济舱
     */
    public static void main(String[] args) {
    //1、让用户输入机票原价，月份，仓位类型
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入机票原价： ");
        double money = sc.nextDouble();

        System.out.println("请您输入机票的月份（1-12）：");
        int month = sc.nextInt();

        System.out.println("请您选择仓位类型： ");
        String type = sc.next();

        //4、调用方法，统计结果
        System.out.println("机票优惠后的价格：" + calc(money, month, type));

    }

    //2、定义方法接收信息，统计优惠后的价格返回
    public static double calc(double money, int month, String type){
        //3、判断用户选择的信息情况
        if(money >= 5 && money <= 10){
            //旺季
            switch (type){
                case "头等舱":
                    money *= 0.9;
                    break;
                case "经济舱":
                    money *= 0.85;
                    break;
                default:
                    System.out.println("您输入的仓位类型有限~~");
            }

        }
        else if(month == 11 || month == 12 || month >=1 && month <= 4){
            //淡季
            switch (type){
                case "头等舱":
                    money *= 0.7;
                    break;
                case "经济舱":
                    money *= 0.65;
                    break;
                default:
                    System.out.println("您输入的仓位类型有限~~");
            }
        }
        else{
            System.out.println("对不起，您输入的月份有问题");
            return -1;
        }
        return money;
    }
}
