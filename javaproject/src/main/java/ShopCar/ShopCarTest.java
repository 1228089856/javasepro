package ShopCar;

import java.util.Scanner;

/**
 * 需求：
 * 模拟购物车模块的功能，需要实现添加商品到购物车中去，同时需要提供修改商品购买数量，
 * 结算商品价格功能（请使用面向对象编程来解决）
 * 分析：
 * 购物车中的每个商品都是一个对象，需要定义一个商品类
 * 购物车本身也是一个对象：可以使用数组对象代表它
 */
public class ShopCarTest {
    public static void main(String[] args) {
        //1、定义商品类，用于后期创建商品对象
        //2、定义购物车对象：使用一个数组对象表示、
        Goods[] shopCar = new Goods[100];
        //3、搭建操作架构
        while (true) {
            System.out.println("请您选择如下命令进行操作： ");
            System.out.println("添加商品到购物车： add");
            System.out.println("查询商品到购物车： query");
            System.out.println("修改商品购买数量： update");
            System.out.println("结算购买商品的金额： pay");
            Scanner sc = new Scanner(System.in);
            System.out.println("请您输入命令： ");
            String command = sc.next();
            switch (command) {
                case "add":
                    //添加商品到购物车
                    addGoods(shopCar, sc);
                    break;
                case "query":
                    //查询商品到购物车
                    queryGoods(shopCar);
                    break;
                case "update":
                    //修改商品购买数量
                    updateGoods(shopCar, sc);
                    break;
                case "pay":
                    //结算购买商品的金额
                    payGoods(shopCar);
                    break;
                default:
                    System.out.println("没有该功能！");
            }
        }
    }

    /*
    需求：
        当用户输入了pay命令后，需要展示全部购买的商品信息和总金额
    分析：
        定义求和变量，遍历购物车数组中的全部商品，累加其单价*购买数量
     */
    public static void payGoods(Goods[] shopCar) {
        queryGoods(shopCar);
        //1、定义一个求和变量累加金额
        double money = 0;
        //2、遍历购物车数组中的全部商品对象，累加 单价*数量
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g != null){
                money += (g.price * g.buyNumber);
            }else {
                break;
            }
        }
        System.out.println("订单总金额： " + money);
    }

    /*
    需求：让用户输入商品id，找出对应的商品修改其购买数量
    分析：
        定义方法能够根据用户输入的ID去购物车数组中查看是否存在该商品对象
        存在返回商品对象的地址，不存在返回null
        判断返回的对象地址是否存在，存在修改其购买数量，不存在就继续
     */
    public static void updateGoods(Goods[] shopCar, Scanner sc) {
        //让用户输入要修改商品的id，根据id查询出要修改的商品对象
        while (true) {
            System.out.println("请输入要修改的商品id: ");
            int id = sc.nextInt();
            Goods g = getGoodsById(shopCar, id);
            if (g == null) {
                //没有该商品
                System.out.println("对不起，没有购买该商品");
            } else {
                //说明存在该商品对象，可以修改它了
                System.out.println("请您输入：" + g.name + "商品最新的购买数量：");
                int buyNumber = sc.nextInt();
                g.buyNumber = buyNumber;
                System.out.println("修改完成！");
                queryGoods(shopCar);
                break;
            }
        }
    }

    public static Goods getGoodsById(Goods[] shopCar, int id) {
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if (g != null) {
                //判断这个商品对象的id是否是我们要找的
                if (g.id == id) {
                    return g;
                }
            } else {
                return null;
            }
        }
        return null;//代表找完了100个商品都没有找到id一样的商品
    }

    /*
    查询购物车中的商品对象信息，并展示出来
     */
    public static void queryGoods(Goods[] shopCar) {
        System.out.println("================查询购物车信息如下================");
        System.out.println("编号\t\t名称\t\t\t价格\t\t\t购买数量");
        //shopCar = {g1,g2,g3,null,null,...}
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if (g != null) {
                //展示这个商品对象
                System.out.println(g.id + "\t\t" + g.name + "\t\t\t" + g.price + "\t\t\t" + g.buyNumber);
            } else {
                //遍历结束
                break;
            }
        }
    }

    /*
    添加商品到购物车=
        需求：
            让用户输入商品信息，并加入到购物车中去，且可立刻查看购物车信息
        分析：
            需要让用户录入商品信息，创建商品对象封装商品信息
            并把商品对象加入到购物车数组中去
            查询购物车信息，就是遍历购物车数组中的每个商品对象
     */
    public static void addGoods(Goods[] shopCar, Scanner sc) {
        //1、录入用户输入的购买商品的信息
        System.out.println("请您输入购买商品的编号（不重复）： ");
        int id = sc.nextInt();
        System.out.println("请您输入购买商品的名称： ");
        String name = sc.next();
        System.out.println("请您输入购买商品的数量： ");
        int buyNumber = sc.nextInt();
        System.out.println("请您输入购买商品的价格：");
        double price = sc.nextDouble();

        //2、把这个商品的信息封装成一个商品对象
        Goods g = new Goods();
        g.id = id;
        g.name = name;
        g.buyNumber = buyNumber;
        g.price = price;

        //3、把这个商品对象添加到购物车数组中去
        //shopCar = {null,null,...}
        for (int i = 0; i < shopCar.length; i++) {
            if (shopCar[i] == null) {
                //说明此位置没有元素存入，把我们新买的商品添加到此处即可
                shopCar[i] = g;
                break;//结束，因为商品已经成功存入了，不需要继续找位置了
            }
        }
        System.out.println("您的商品：" + g.name + "已经添加到购物车");
    }


}
