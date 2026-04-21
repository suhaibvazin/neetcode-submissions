/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        //dfs
        return  dfs(root)!=-1;
    }

    private int dfs(TreeNode root){

        if(root == null){
            return 0;
        }
        //find left depth
        int left = dfs(root.left);
        //check early exit
        if (left == -1) return -1;

        //find right depth
        int right = dfs(root.right);
        //check early exit
        if (right == -1) return -1;

        //update value looking at the node childerens at each level
        //if depth diff is greater than 1 return by updating boolean 
        if(Math.abs(left - right) > 1){
            return -1;
        }

        return 1+ Math.max(left,right);

    }
}
