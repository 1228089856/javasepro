import java.util.Random;

public class developCaptchas {
    /*
        需求：定义方法实现随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母
        分析：
            1、定义一个方法，生成验证法返回：方法参数是位数、方法的返回值类型是String
            2、在方法内部使用for循环生成指定位数的随机字符，并连接起来
            3、把连接好的随机字符作为一组验证码进行返回
     */
    public static void main(String[] args) {
        //4、调用获取验证码的方法得到一个随机验证码
        String code = createCode(5);
        System.out.println("随机验证码：" + code);
    }

    //1、定义一个方法返回一个随机验证码，是否需要返回值类型声明？String 是否需要声明形参？ int n
    public static String createCode(int n) {
        //3、定义一个字符串变量记录生成的随机字符
        String code = "";
        Random r = new Random();
        //2、定义一个for循环，循环n次，一次生成随机字符
        for (int i = 0; i < n; i++) {
            //3、生成一个随机字符：英文大写 小写 数字
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    //大写字符（A 65 - Z 65+25）  （0-25） + 65
                    char ch = (char) (r.nextInt(26) + 65);
                    code += ch;
                    break;
                case 1:
                    //小写字符（a 97 - z 95+25）  （0-25） + 97
                    char ch1 = (char) (r.nextInt(26) + 65);
                    code += ch1;
                    break;
                case 2:
                    //数字字符
                    code += r.nextInt(10);
                    break;
            }
        }
        return code;
    }
}
