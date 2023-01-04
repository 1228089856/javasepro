package ArrayList集合案例;

import java.util.ArrayList;
import java.util.Scanner;

/*
学号      姓名      年龄      班级
"20180302", "叶孤城"    , 23     ,  "护理一班"
"20180303" ,"东方不败"  ,  23    ,   "推拿二班"
"20180304", "西门吹雪",   26   ,    "中药学四班"
"20180305", "梅超风"   ,  26    ,     "神经科二班"
需求：
    后台程序需要存储如上学生信息并展示，然后要提供按照学生搜索学生信息的功能
分析
    1、定义Student类，定义ArrayList集合存储如上学生对象信息，并遍历展示出来
    2、提供一个方法，可以接收ArrayList集合，和要搜索的学号，返回搜索到的学生对象信息，并展示
    3、使用死循环，让用户可以不听的搜索
 */
public class elementSearch {
    public static void main(String[] args) {
        //1、定义学生类
        //2、创建集合存储学生对象，创建学生对象封装学生信息
        //  把学号是哪个对象添加到集合中去
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("20180302", "叶孤城", 23, "护理一班"));
        students.add(new Student("20180303", "东方不败", 23, "推拿二班"));
        students.add(new Student("20180304", "西门吹雪", 26, "中药学四班"));
        students.add(new Student("20180305", "梅超风", 26, "神经科二班"));
        //3、遍历这些学生信息展示
        System.out.println("学号\t名称\t年龄\t班级");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println(s.getStudyNumber() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getClassName());
        }
        //4、定义方法完成按照学号的搜索功能
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请您输入学号查询学生对象：");
            String studyNumber = sc.next();
            //5、调用方法查询
            Student s = getStudentById(students,studyNumber);
            //6、判断s中是否存在学生对象地址
            if(s == null){
                System.out.println("对不起，查无此人");
            }else {
                System.out.println("您查询到学生信息如下：");
                System.out.println(s.getStudyNumber() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getClassName());
            }

        }

    }

    /**
     * 根据学生的学号查询学生对象返回
     * @param students     存储全部学生对象的集合
     * @param studyNumber   搜索的学生的学号
     * @return 学生对象 | null
     */

    public static Student getStudentById(ArrayList<Student> students,String studyNumber){
        //1、遍历全部学生对象
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            //2、询问当前遍历的这个学生对象的学号，是否是我们要找的学生学号
            if(s.getStudyNumber().equals(studyNumber))
                // 这个s代表的学生对象，就是我们要找的，返回它
                return s;
        }
        //查无此人
        return null;

    }
}
