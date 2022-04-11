import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
//        //定义数组
//        int[] arr = {1,10,6,3,7,9,5,4,8};
//        //调用方法，进行快速排列
//        quickSort(arr,0,arr.length-1);
//
//
//        //遍历数
//        for (int i = 0;i<arr.length;i++){
//            System.out.print(arr[i]);
//        }

        //定义一个数组
        int[] arr = new int[10000000];
        Random r = new Random();
        //给数组元素赋值
        for (int i=0;i<arr.length;i++){
            //生成随机数
            int num = r.nextInt();
            arr[i] = num;
        }

        //排序之前记录时间
        long strat = System.currentTimeMillis();
        //排序
        quickSort(arr,0, arr.length-1);
        //排序之后记录时间
        long end = System.currentTimeMillis();
        System.out.println(end - strat);
    }

    /*
     * 定义方法，用来进行快速排列
     * left左边索引位，right右边索引位
     */
    public static void quickSort(int[] arr,int left,int right){
        //进行判断，如果左边索引比右边索引要大，是不合法的，直接用return结束这个方法
        if (left>right){
            return;
        }
        //定义变量保存基准数
        int base = arr[left];
        //定义变量i，指向最左边
        int i = left;
        //定义变量j，指向最右边
        int j = right;

        //当i和j不相遇的时候，在循环中进行检索
        while (i != j){
            //先由j从右往左进行检索比基准数小的，如果检索到比基准数小的就停下
            //如果检索到比基准数大的或者相等的，就继续检索
            while (arr[j] >= base && i<j){
                j--;//j从右往左移动
            }
            //i从左往右检索
            while (arr[i]<=base&& i<j){
                i++; //ic从左往右检索
            }

            //代码走到这里。i停下了，j也停下了。然后交换i和j位置的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //如果i = j，说明i和j相遇，就交换基准数这个元素和相遇位置的元素
        arr[left] = arr[i];
        arr[i] = base;

        //基准数在这里就归位了，左边的数字都比他小，右边的数字都比他大
        //排基准数左边8788
        quickSort(arr,left,i-1);
        //排完左边排右边
        quickSort(arr,j+1,right);
    }
}
