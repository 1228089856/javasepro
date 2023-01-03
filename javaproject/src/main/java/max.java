public class max {
    public static void main(String[] args) {
        //求数组最大值
        int arr[] = {10, 20, 30, 40};
        int max = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("数组的最大值是：" + max);
    }
}
