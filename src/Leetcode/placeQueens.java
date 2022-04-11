package Leetcode;

public class placeQueens {
    public static void main(String[] args) {
       new placeQueens().placeQueens(8);

    }

    /*
    数组索引是行号，数组元素是列号
     */
    int[] cols;
    //多少种方法
    int ways;
    void placeQueens(int n){

        if (n<1) return;
        cols = new int[n];
        place(0);
        System.out.println(n+"皇后一共有"+ways+"种摆法");
        show();
    }

    /**
     * 从第row行开始摆放皇后
     * @param row
     */
    void place(int row){
        if (row == cols.length){
            ways++;
            return;
        }
        for (int col=0;col<cols.length;col++){
            if (isValid(row,col)){
                //在第row行，第col列摆放皇后
                cols[row] = col;
                place(row+1);
            }
        }
    }

    /**
     * 判断第row行 第col列是否可以摆放皇后
     */
    boolean isValid(int row,int col){
        for (int i =0;i<row;i++){
            //第col列有皇后
           if (cols[i] == col ){
               return false;
           }
           //斜线上是否有皇后 （斜率）
           if (row - i == Math.abs(col - cols[i])){
               return false;
           }
        }
        return true;
    }

    void show(){
        for (int row = 0;row<cols.length;row++){
            for(int col = 0;col<cols.length;col++){
                if (cols[row] == col){
                    System.out.print("1 ");
                }else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
