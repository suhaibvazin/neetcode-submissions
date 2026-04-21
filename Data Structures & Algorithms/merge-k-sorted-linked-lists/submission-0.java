/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        //we need min-heap, a datastructure that always gives min value when polled

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        //insert all haeds to min heap(priority queue)
        for(ListNode list:lists){
            minHeap.add(list);
        }
        //while this heap is not null, 
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(!minHeap.isEmpty()){
            //poll and add to dummy tail
            ListNode small = minHeap.poll();
            tail.next = small;
            tail = tail.next;
            //if head has next , add to min heap
            if(small.next != null){
                minHeap.add(small.next);
            }
        }
        
        return dummy.next;
    }
}
