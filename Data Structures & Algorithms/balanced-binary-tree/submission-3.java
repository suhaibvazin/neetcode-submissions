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

    boolean isBlanced = true;
    public boolean isBalanced(TreeNode root) {
        //dfs
        dfs(root);
        return isBlanced;
    }

    private int dfs(TreeNode root){

        if(root == null){
            return 0;
        }
        //find left depth
        int left = dfs(root.left);
        //find right depth
        int right = dfs(root.right);

        //update value looking at the node childerens at each level
        //if depth diff is greater than 1 return by updating boolean 
        if(Math.abs(left - right) > 1){
            isBlanced = false;
        }

        return 1+ Math.max(left,right);

    }
}
