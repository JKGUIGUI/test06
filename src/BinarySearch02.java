import java.util.Arrays;

public class BinarySearch02 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Arrays.sort(arr);
        int j = Arrays.binarySearch(arr,6);
    }

    public static int binarySearch(int[] arr,int item,int low,int high){
        if (low>high){
            return -1;
        }
        int mid = (low+high)/2;
        int guess = arr[mid];
        if (guess == item){
            return mid;
        }
        else if (guess > item){
            return binarySearch(arr,item,low,mid-1);
        }
        else{
            return binarySearch(arr, item, mid+1, high);
        }
    }
}

