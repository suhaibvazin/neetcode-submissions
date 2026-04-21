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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // A null subRoot is always a subtree
        if (subRoot == null) return true;
        // If root is null but subRoot isn't, it can't be a subtree
        if (root == null) return false;
        
        // 1. Check if the trees rooted at current nodes are identical
        if(root.val == subRoot.val){
            if (isSameTree(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode copy){
        //if both are null return true, we reached end with same elements
        if(root == copy){
            return true;
        }

        if(root ==null || copy == null || root.val!=copy.val){
            return false;
        }
        //call method recursively for both sides and should return true
        return isSameTree(root.left,copy.left) && isSameTree(root.right,copy.right);
    }
}
