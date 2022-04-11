import java.io.IOException;
import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0,0,0,0,0,0,0};
        int[] res = minPathSum(nums);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    public static int[] minPathSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0;i<nums.length;i++){
            map.put(i,nums[i]);
        }

        for(int i = 0;i<1000;i++){
            for(int j = 0;j<1000;j++){
                while (j != 0){
                    int a = j % 10;
                    j = j / 10;
                    int b = a * i;
                    while (b != 0){
                        int c = b % 10;
                        map.put(c,map.get(c)-1);
                        if(map.get(c) < 0){
                            continue;
                        }
                        b = j / 10;
                    }
                }

                int d = i * j;
                while (d != 0){
                    int c = d % 10;
                    map.put(c,map.get(c)-1);
                    if(map.get(c) < 0){
                        continue;
                    }
                    d = j / 10;
                }

                for(int z = 0;z < map.size();z++){
                    if(map.get(z) != 0){
                       break;
                    }
                    if(z==map.size()-1){
                        res[0] = i;
                        res[1] = j;
                    }
                }


            }
        }

        return res;
    }
    }
