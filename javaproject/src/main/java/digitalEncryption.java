import java.util.Scanner;

public class digitalEncryption {
    /*
    需求：
        某系统的数字密码：比如1983，采用加密方式进行传输，规则如下：先得到每位数，然后每位数都加上5，再对10求余，
        最后将所有数字反转，得到一串新数

    分析：将每位数据存入到数组中去，遍历数组每位数据按照规则进行更改，把更改后的数据重新存入到数组中
    将数组的前后元素进行交换，数组中的最终元素就是加密后的结果
     */
    public static void main(String[] args) {
        //1、定义一个数组存入需要加密的数据
        System.out.println("请您输入需要加密的数字个数：");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];

        //2、录入需要加密的数字
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请您输入加密的第" + (i + 1) + "个数字：");
            int number = sc.nextInt();
            arr[i] = number;
        }

        //3、打印数组内容看一下
        printArray(arr);

        //4、核心逻辑（对数组中的数据进行加密）
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] + 5) % 10;
        }

        //5、核心逻辑（对数组中加密的数据进行反转，才是最终加密的结果）
        for (int i = 0, j = arr.length -1; i < j ; i++,j--) {
            //直接交换两者的位置的值即可
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length ? arr[i] : arr[i] + ", ");
        }
        System.out.println("]");
    }
}
