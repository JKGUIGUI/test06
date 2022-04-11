package Leetcode;

import java.util.*;

public class test02 {
    static int quicksort (int[] nums,int left,int right,int item){
        if(left > right)
            return -1;

        int mid = (left+right)>>2;
        if(item == nums[mid]) return mid;

        if(item > nums[mid]) {
            return quicksort(nums,mid+1,right,item);
        }else {
            return quicksort(nums, left, mid - 1, item);
        }


    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int index = quicksort(arr,0,6, 3);
        System.out.println(index);
    }

}


