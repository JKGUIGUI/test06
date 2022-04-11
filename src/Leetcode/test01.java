package Leetcode;

import java.util.List;

/**
 * 给定n，构造长度为n的排列，使满足j<j<k的aj，ai，ak，不出现ak+ai=aj*2
 */
public class test01 {
    public static void main(String[] args) {
        Solve solve = new Solve();
        solve.solve(1,10,0);
        for (int i=1;i<= 10;i++){
            System.out.print(solve.arr[i]/2+" ");
        }
    }
}

/*
l最左边数，r最右边数，mark=1奇数，mark=0偶数
 */
class Solve{
    int[] arr = new int[100];
    void solve(int l,int r,int mark){
        //如果数组只有一个数
        if (l == r){
            //奇数边
            if (mark == 1){
                arr[l] = 1;
            }if (mark == 0){
                arr[l] = 2;
            }
            return;
        }
        int mid = (l+r)>>1; //求数组的中间数
        solve(l,mid,1);//左边为基
        solve(mid+1,r,0);  //右边为偶
        for (int i = l;i<=r;i++){
            arr[i] = arr[i]*2 - mark;
        }
        return;
    }



}
