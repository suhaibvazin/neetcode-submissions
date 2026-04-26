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

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        getMaxPath(root);
        return maxSum;
        
    }

    private int getMaxPath(TreeNode root){
        //post-order, cause node need to0 know its left suma nd right sum to decide
        //also need to find local sum, to update maxSum and return biggest child path ,
        //so that pareent node can take the biggest path

        //handle nul case

        if(root == null){
            return 0;
        }

        int leftSum = Math.max(getMaxPath(root.left),0);
        int rightSum = Math.max(getMaxPath(root.right),0);

        int locaLSum = root.val + leftSum +  rightSum;

        //update local max , cause a nodes local can possibiliy be a maxSum
        maxSum = Math.max(maxSum, locaLSum);

        //give the parent largest sum path
        return root.val + Math.max(leftSum,rightSum);

    }
}
