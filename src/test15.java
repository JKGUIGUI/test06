import java.io.StringWriter;
import java.util.*;

public class test15 {
    public int partitionArray(int[] nums, int k) {
        if(nums.length ==0||nums == null){
            return 0;
        }

        int left = 0;
        int right = nums.length - 1 ;


        while(left < right){
            while(nums[right] >= k && left < right){
                right--;
            }
            while(nums[left] < k && left < right){
                left++;
            }

            if(left <= right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
                right--;
            }
        }

        if(nums[nums.length-1] < k){
            return nums.length;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};
        test15 t1 = new test15();


        System.out.println(t1.partitionArray(nums,9));
    }

}



