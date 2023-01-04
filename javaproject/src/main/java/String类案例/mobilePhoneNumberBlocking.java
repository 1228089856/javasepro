package String类案例;

import java.util.Scanner;

/*
需求：
    以字符串的形式从键盘接收一个手机号，将中间四位号码屏蔽
分析：
    1、键盘录入一个字符串，用Scanner 实现
    2、截取字符串前三位，截取字符串后四位
    3、将截取后的两个字符串，中间加上****进行拼接，输出结果即可
 */
public class mobilePhoneNumberBlocking {
    public static void main(String[] args) {
        //1、键盘录入一个手机号码
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入您的手机号码：");
        String telephone = sc.next();

        //2、截取号码的前三位，后四位
        String before = telephone.substring(0,3);
        String after = telephone.substring(7);

        String  s = before + "****" + after;
        System.out.println(s);
    }
}
