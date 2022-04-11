package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class LevelOrder {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        bfs(root);
        return res;
    }

    void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> cor = new ArrayList<>();

        queue.offer(root);


        while (!queue.isEmpty()){
            int size = queue.size();
            //搜索这一层
            for(int i = 0;i<size;i++){
                TreeNode root1 = queue.poll();
                cor.add(root1.val);
                if(root.left != null){
                    queue.offer(root.left);
                }if(root.right != null){
                    queue.offer(root.right);
                }
            }
            res.add(cor);


        }
    }


}
