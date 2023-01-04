package ArrayList集合案例;

import java.util.ArrayList;

/*
需求：某影院系统需要在后台存储上述三部电影，然后依次展示出来
    《肖申克的救赎》 , 9.7 , 罗宾汉
    "《霸王别姬》" , 9.6 , "张国荣 ， 张丰毅"
    "《阿甘正传》" , 9.5 , "汤姆.汉克斯"
分析：
    1、定义一个电影类，定义一个集合存储电影对象
    2、创建3个电影对象，封装相关数据，把3个对象存入到集合中去
    3、遍历集合中的3个对象，输出相关信息
 */
public class storesObjectsOfCustomTypes {
    public static void main(String[] args) {
        //目标：理解ArrayList集合存储自定义对象
        //1、定义电影类
        //2、创建三个电影对象
        Movie m1 = new Movie("《肖申克的救赎》", 9.7, "罗宾汉");
        Movie m2 = new Movie("《霸王别姬》", 9.6, "张国荣 ， 张丰毅");
        Movie m3 = new Movie("《阿甘正传》", 9.5, "汤姆.汉克斯");
        //3、创建一个电影类型的ArrayList集合，存储三部电影对象
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        //4、遍历电影类型的集合中的每个电影对象，访问到它的信息即可
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.println("电影名称：" + m.getName());
            System.out.println("电影得分：" + m.getScore());
            System.out.println("电影主演：" + m.getActor());
            System.out.println("-----------------");
        }
    }
}
