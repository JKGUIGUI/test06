package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point {
    int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
public class Course {
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        int[] directionX = {1,1,-1,-1,2,2,-2,-2};
        int[] directionY = {2,-2,2,-2,1,-1,1,-1};

        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int step = 0;

        while (!queue.isEmpty()){
            Point point = queue.poll();
            for(int i = 0;i<8;i++){
                if(point.x == destination.x && point.y == destination.y){
                    return step;
                }
                Point s = new Point(
                        point.x + directionX[i],
                        point.y+directionY[i]
                );
                if(!isBound(point,grid)){
                    continue;
                }

                queue.offer(s);
                grid[s.x][s.y] = true;
            }
            step++;
        }

        return -1;
    }

    boolean isBound(Point point,boolean[][] grid){
        if(point.x < 0 || point.x > grid.length  || point.y < 0 || point.y > grid[0].length){
            return  false;
        }

        return (grid[point.x][point.y] == false);
    }
}
