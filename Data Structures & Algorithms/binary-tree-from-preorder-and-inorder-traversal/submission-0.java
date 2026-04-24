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
    Map<Integer,Integer> inOrderMap = new HashMap<>();;
    int preOrderIndex =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // build inOrderMap
        for(int i =0; i< inorder.length ; i++){
            inOrderMap.put(inorder[i],i);
        }

        //then call we can create tree left and right recursively
        return createTree(preorder,0,inorder.length-1);
        
    }
    private TreeNode createTree(int[] preorder,int left,int right){



        //breaking condition
        if(left > right){
            return null; //means no elements left
        }

        int val = preorder[preOrderIndex++];

        //make node
        TreeNode node = new TreeNode(val);


        //go left then right
        //for that find mid from map
        int mid = inOrderMap.get(val);


        //left
        node.left = createTree(preorder,left,mid-1);
        //right
         node.right = createTree(preorder,mid+1,right);

        return node;

    }
}
