public class arraySorting {
    public static void main(String[] args) {
        //冒泡排序
        //每次从数组中找出最大值放到数组的后面去
        /*
        实现冒泡排序的关键步骤分析
        1、确定总共需要做几轮：数组的长度-1
        2、每轮比较几次：
         i(轮数）    次数
         1          3
         2          2
         3          1
         所以：次数规律：数组的长度-1
         */

        //1、定义一个数组，存储一些数据
        int[] arr = {5, 2, 3, 1};
        //          0  1  2 3

        //2、定义一个循环控制比较的轮数
        for (int i = 1; i <= arr.length - 1; i++) {
            //i == 1 比较的次数 3   j = 0 1 2
            //i == 2 比较的次数 2   j = 0 1
            //i == 3 比较的次数 1   j = 0
            //3、定义一个循环控制每轮比较的次数，占位
            for (int j = 0; j < arr.length - i; j++) {
                //判断j当前位置的元素值 是否 大于后一个位置 若较大 则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //遍历数组内容输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
