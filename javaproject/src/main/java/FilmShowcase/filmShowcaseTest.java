package FilmShowcase;

/*
    需求：使用面向对象编程，模仿电影信息的展示
    分析：
        一部电影是一个java对象，需要先设计电影类，再创建电影对象
        散步电影对象可以采用数组存储起来
        依次遍历数组中的每个电影对象，取出其信息进行展示
    目标：完成电影信息的展示案例，理解面向对象编程的代码

    "《长津湖》", 9.7, "吴京"
    "《我和我的父亲》" , 9.6 , "吴京"
    "《扑水少年》", 9.5 , "王川"
 */
public class filmShowcaseTest {
    public static void main(String[] args) {
        //1、设计电影类
        //2、创建3个电影对象，封装电影的信息
        Movie m1 = new Movie("《长津湖》", 9.7, "吴京");
        Movie m2 = new Movie("《我和我的父亲》", 9.6, "吴京");
        Movie m3 = new Movie("《扑水少年》", 9.5, "王川");
        //3、定义一个电影类型的数组，存储3部电影对象
        Movie[] movies = new Movie[3];
        movies[0] = m1;
        movies[1] = m2;
        movies[2] = m3;
        //4、遍历数组红的每个电影对象，然后获取它的信息展示出来
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            System.out.println("电影名：" + m.getName());
            System.out.println("得分：" + m.getScore());
            System.out.println("作者：" + m.getActor());
            System.out.println("---------------------");
        }
    }
}
