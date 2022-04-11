public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int index = binarySearch(arr,5);
        System.out.println(index);


    }

    public static int binarySearch(int[] arr,int item){
        int low = 0;
        int higt = arr.length-1;
        int index = -1;

        while (low<=higt) {
            int mid = (low + higt) / 2;
            int guess = arr[mid];
            if (guess == item) {
                index = mid;
                break;
            }
            if (guess > item) {
                higt = mid - 1;
            }
            if (guess < item) {
                low = mid + 1;
            }
        }
        return index;
    }
}

