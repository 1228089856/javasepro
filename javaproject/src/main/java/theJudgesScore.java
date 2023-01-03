import java.util.Scanner;

public class theJudgesScore {
    /*需求：
    在唱歌比赛中，有6名评委给选手打分，分数范围是【0-100】之间的整数。选手的最后得分为：去掉最高分、最低分后的4个评委的平均分，
    请完成上述过程并计算出选手的得分
    分析：
            1、把六个评委的分数录入到程序中去——>使用数组
        2、遍历数组中的每个数据，进行累加求和，并找出最高分，最低分
        3、按照分数的计算规则算出平均分
     */
    public static void main(String[] args) {
        //1、定义一个动态初始化的数组，用于后期录入6个评委的分数
        int[] scores = new int[6];
        //2、录入6个评委的分数
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请您输入第" + (i + 1) + "个评委的打分");
            int score = sc.nextInt();
            //3、把这个分数存入到数组的对应位置处
            scores[i] = score;
        }

        //4、遍历数组中的每个数据，找到最高分和最低分和总分
        int max = scores[0];
        int min = scores[0];
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            //替换最大值变量存储的数据
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                //替换最小值变量存储的数据
                min = scores[i];
            }

            //统计总分
            sum += scores[i];
        }
        //4、统计平均分
        double average = (sum - max - min) * 1.0 / (scores.length - 2);
        System.out.println("选手最终得分是：" + average);
    }
}
