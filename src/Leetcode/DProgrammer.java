package Leetcode;

public class DProgrammer {
    public static void main(String[] args) {
        System.out.println(coins2(50));
    }


    static int coins2(int n){
        if(n<1) return -1;
        int[] dp = new int[n+1];

        return coins2(n,dp);
    }

    private static int coins2(int n, int[] dp) {
        if (dp[n] == 0){
            int min1 = Math.min(coins2(n-25,dp),coins2(n-20,dp));
            int min2 = Math.min(coins2(n-5,dp),coins2(n-1,dp));
            dp[n] = Math.min(min1,min2)+1;
        }
        return dp[n];
    }


}
