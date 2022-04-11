public class QuickSort01 {
    public static void main(String[] args) {
        int[] arr = {6,3,7,9,5,4,8,10,1};
        QucikSort(arr,0, arr.length-1);
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void QucikSort(int arr[],int left,int right){
        if (left > right){
            return;
        }
        int base = arr[left];
        int i =  left;
        int j = right;

        while (i != j){
            while (base <= arr[j] && j > i){
                j--;
            }
            while (base >= arr[i] && i<j){
                i++;
            }

            //交换i和j的位置
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }

        //交换基准数与相遇位置的数
        arr[left] = arr[i];
        arr[i] = base;

        QucikSort(arr,left,i-1);
        QucikSort(arr,j+1,right);
    }
}
