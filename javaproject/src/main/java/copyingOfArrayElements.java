public class copyingOfArrayElements {
    /*
    需求：把一个数组中的元素复制到另一个新数组中去
    分析：
        需要动态初始化一个数组，长度与原数组一样
        遍历原数组的每个元素，依次赋值给新数组。
     */
    public static void main(String[] args) {
        int[] arr1 = {11,22,33,44};
        //int[] arr2 = arr1;// 没有完成数组复制
        int[] arr2 = new int[arr1.length];

        copy(arr1, arr2);

        printArray(arr1);
        printArray(arr2);


    }

    public  static  void printArray(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i == arr.length - 1? arr[i] : arr[i] + ",");
        }
        System.out.println("]");
    }
    public static void copy(int[] arr1, int[] arr2){
        //正式完成元素的复制
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];

        }
    }
}
