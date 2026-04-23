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
    public int kthSmallest(TreeNode root, int k) {

        //go far left keep inserting in stack
        //then  increment count,if right exist go the far left do the same, if not pop new element

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int n = 0;

        while(!stack.isEmpty() || curr!=null){
            while(curr!=null){
                stack.push(curr);
                curr= curr.left;
            }
            curr = stack.pop();
            n++;
            if(n==k){
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;   
    }
}
