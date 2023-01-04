package String类案例;

import java.util.Scanner;

/*
需求：模拟用户登录功能，最多只给三次机会
分析：
     系统后台定义好正确等待登录名称，密码
     使用循环控制三次，让用户输入正确的登录名和密码，判断是否登录成功，登录成功则不再进行登录；登录失败给出提示，并让用户继续登录
 */
public class userLogsOn {
    public static void main(String[] args) {
        //1、定义正确的登录名称和密码
        String okLoginName = "admin";
        String okPassword = "123456";

        //2、定义一个循环，循环3次，让用户登录
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= 3; i++) {
            System.out.println("请您输入登录名称：");
            String loginName = sc.next();
            System.out.println("请您输入登录密码：");
            String password = sc.next();

            //3、判断登录是否成功？
            if (okLoginName.equals(loginName)) {
                //4、判断密码是否正确
                if (okPassword.equals(password)) {
                    System.out.println("登录成功！");
                    break;
                } else {
                    //密码错误了
                    System.out.println("您的密码不正确！您还剩余" + (3 - i) + "次机会");
                }

            } else {
                System.out.println("登录名称错误了！您还剩余" + (3 - i) + "次机会");
            }
        }
    }
}
