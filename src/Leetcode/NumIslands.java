package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {

    class Coordinary{
        int x;
        int y;
        public Coordinary(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0||grid[0].length == 0){
            return 0;
        }
        int res = 0;

        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j< grid[0].length;j++){
                if(grid[i][j]){
                    bfs(grid,i,j);
                    res ++;
                }
            }
        }

        return res;
    }

    //搜索x,y附近有没有1
    void bfs(boolean[][] grid,int x,int y){

        int[] directionX = {0,0,1,-1};
        int[] directionY = {1,-1,0,0};

        Queue<Coordinary> queue = new LinkedList<>();

        queue.offer(new Coordinary(x,y));
        grid[x][y] = false;

        while(!queue.isEmpty()){
            Coordinary coor = queue.poll();
            // 搜索四周
            for(int i = 0;i<4;i++){
                Coordinary adj = new Coordinary(
                        coor.x + directionX[i],
                        coor.y + directionY[i]
                );

                //如果是边界
                if(!isinBound(adj,grid)){
                    continue;
                }

                //如果这个点是1
                if(grid[adj.x][adj.y]){
                    grid[adj.x][adj.y] = false; //将这个点标识为搜索过的点
                    queue.offer(adj);
                }
            }

        }
    }

    //判读是否出界
    boolean isinBound(Coordinary coordinary,boolean[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        return coordinary.x>=0 && coordinary.x<m && coordinary.y >= 0 && coordinary.y<n;
    }

}
