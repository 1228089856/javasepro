package ArrayList集合案例;

import java.util.ArrayList;

/*
 需求：
    某个班级的考试在系统上进行，成绩大致为：98,77,66,89,79,50,100
    现在需要先把成绩低于80分一下的数据去掉
 分析：
    1、定义ArrayList集合存储多名学员的成绩
    2、遍历集合每个元素，如果元素值低于80分，去掉它
 */
public class traverseAndDeleteElements {
    public static void main(String[] args) {
        //目标：学习遍历并删除元素的正确方案
        //1、创建一个ArrayList集合存储一个班级学生的成绩
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(98);
        scores.add(77);
        scores.add(66);
        scores.add(89);
        scores.add(79);
        scores.add(50);
        scores.add(100);
        System.out.println(scores);

        //2、把低于80分的成绩从集合中去掉
        for (int i = 0; i < scores.size(); i++) {
            int score = scores.get(i);
            if (score < 80) {
                //这个分数删除
                scores.remove(i);
                i--;//删除成功后，必须退一步，这样可以保证下次回到这个位置，如此则不会跳过数据
            }
        }
        System.out.println(scores);
        //方法二：倒着遍历就可以了
    }

}
