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
    public List<Integer> rightSideView(TreeNode root) {

        if(root ==null){
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();

        List<Integer> ansList = new ArrayList<>();
        //assign root node to queue
        queue.add(root);

        //iterate untill queue is empty , by adding non null childrents to queue
        //add right children by default , if no righ add left.
        while(!queue.isEmpty()){
            int qSize = queue.size();
            int counter = 1;
            for(int i =0 ;i<qSize;i++){
                TreeNode node = queue.poll();
                if(counter>0){
                    ansList.add(node.val);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

                if(node.left!=null){
                    queue.add(node.left);
                }
                counter--;
            }
        } 

        return ansList;
        
    }
}
