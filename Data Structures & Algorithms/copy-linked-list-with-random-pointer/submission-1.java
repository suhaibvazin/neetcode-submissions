/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Map<Node,Node> nodeMap = new HashMap<>();

        //iterate once and create a hashmap of ogt->copy*(only value)
        Node og = head;

        while(og!=null){
            nodeMap.put(og,new Node(og.val));
            og = og.next;
        }
        //since we visited all elements and made a hashmap ,
        //in next iteration we can fill random and next.

        //reset temp
        og = head;
        while(og!=null){
            nodeMap.get(og).next = nodeMap.get(og.next);
            nodeMap.get(og).random = nodeMap.get(og.random);

            og = og.next;
        }

        //return 
        return nodeMap.get(head);

        
    }
}
