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

public class Codec {

   public String serialize(TreeNode root) {
        if (root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                sb.append("n-"); // Use 'n' for null
                continue;
            }
            
            sb.append(node.val).append("-");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // 2. DESERIALIZE: Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) return null;

    // Split the string into an array of tokens
    String[] values = data.split("-");
    if (values[0].equals("n")) return null;

    // Use an index or a pointer to keep track of our position in the array
    int i = 0;
    TreeNode root = new TreeNode(Integer.parseInt(values[i++]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty() && i < values.length) {
        TreeNode parent = queue.poll();

        // Process Left Child
        if (!values[i].equals("n")) {
            parent.left = new TreeNode(Integer.parseInt(values[i]));
            queue.add(parent.left);
        }
        i++; // Move to next token

        // Process Right Child (ensure we don't go out of bounds)
        if (i < values.length && !values[i].equals("n")) {
            parent.right = new TreeNode(Integer.parseInt(values[i]));
            queue.add(parent.right);
        }
        i++; // Move to next token
    }

    return root;
}
}
