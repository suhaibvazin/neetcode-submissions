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
    int diameter =0;
    public int diameterOfBinaryTree(TreeNode root) {
        //do dfs,while updating diameter as leftheight+rightheight
        dfs(root);
        return diameter;
        
    }
    private int dfs(TreeNode node){
        //null check 
        if(node ==null){
            return 0;
        }

        //find left and right height recursively

        int left = dfs(node.left);
        int right = dfs(node.right);

        //update diameter as left plus right from each node level

        diameter = Math.max(diameter, right+left);

        //return height
        return 1+Math.max(right,left);
    }
}
