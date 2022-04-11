import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[] array = {13,56,2,8,19,34,29};
        System.out.println(Arrays.toString(array));
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /*
    分解
     */
    public static void mergeSort(int[] arr,int low,int heigh){
        if (low>=heigh){
            return;
        }

        int mid = (low+heigh)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,heigh);
        merge(arr,low,mid,heigh); //合并
    }

    /*
    合并
     */
    private static void merge(int[] arr,int low,int mid,int height) {

        int s1 =low; //第一个归并段的开始
        int s2 = mid +1; //第二个归并段的开始
        int[] ret = new int[height - low +1];
        int i = 0;  //表示ret数组的下标

        while(s1 <= mid && s2 <= height){
            if (arr[s1] < arr[s2]){
                ret[i++] = arr[s1++];
            }else {
                ret[i++] = arr[s2++];
            }
        }

        while (s1 <= mid){
            ret[i++] = arr[s1++];
        }
        while (s2 <= height){
            ret[i++] = arr[s2++];
        }
        for (int j=0;j<ret.length;j++){
            arr[j+low] = ret[j];
        }

    }


}
