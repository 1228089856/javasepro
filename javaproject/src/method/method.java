public class method {
    public static void main(String[] args) {
        //求两个数的和
        int rs = add(100, 200);
        System.out.println(rs);
        System.out.println("==================");

        //计算1-n的和返回
        System.out.println("1-100的和是" + sum(100));
        System.out.println("==================");

        //判断奇数还是偶数
        checkOddOrEven(11);
        System.out.println("==================");

        //数组求最值改方法实现
        int[] ages = {23, 19, 25, 78, 34};
        int max = getArrayMaxData(ages);
        System.out.println("最大值数据是：" + max);
        System.out.println("==================");

        //从数组中查询指定元素的索引
        int[] arr = {11, 22, 33, 44, 887, 19};
        int index = searchIndex(arr, 11);
        System.out.println("您查询的数据的索引是" + index);
    }

    //求两个数的和
    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    //计算1-n的和返回
    public static int sum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }


    //判断整数是奇数还是偶数
    public static void checkOddOrEven(int number) {
        if (number % 2 == 0) {
            System.out.println(number + "是偶数");
        } else {
            System.out.println(number + "是奇数");
        }
    }

    //数组求最值改方法实现
    public static int getArrayMaxData(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

        }
        return max;
    }


    //从数组中查询指定元素的索引
    //需求：设计一个方法可以接收整型数组，和要查询的元素值；最终要返回元素在该数组中的索引，如果数组中不存在该元素则返回-1
    public static int searchIndex(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }
}

