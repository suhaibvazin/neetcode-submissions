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
    public int maxDepth(TreeNode root) {

        //null check
        if(root == null){
            return 0;
        }

        //BFS 
        //increment counter on each level to get the depth

        //queue
        Queue<TreeNode> queue = new  LinkedList<>();

        queue.add(root);

        int counter = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size;i++){
               TreeNode node = queue.poll();
               if(node.left!=null){
                queue.add(node.left);
               }
               if(node.right!=null){
                queue.add(node.right);
               }     
            }
            counter++;
        }

        return counter;
        
    }
}
