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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root ==null){
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> ansList = new ArrayList<>();
        //assign root node to queue
        queue.add(root);

        //iterate untill queue is empty , by adding non null childrents to queue
        while(!queue.isEmpty()){
            int qSize = queue.size();
            //initialise intermediate list
            List<Integer> levelList = new ArrayList<>();
            for(int i =0 ;i<qSize;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                levelList.add(node.val);
            }
            //level end add the level list to master list
            ansList.add(levelList);
        } 

        //return ansList
        return ansList;
    }
}
