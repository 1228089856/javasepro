public class Test {
    public static void main(String[] args) {
        //创建汽车对象
        Car c = new Car();
        c.name = "宝马";
        c.price = 38.9;
        System.out.println(c.name);
        System.out.println(c.price);
        c.start();
        c.run();
    }
}
