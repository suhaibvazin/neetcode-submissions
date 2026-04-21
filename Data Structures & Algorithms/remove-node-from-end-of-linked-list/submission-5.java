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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // //find length
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // int  len = 0;
        // ListNode pointer = head;
        // while(pointer!=null){
        //     len++;
        //     pointer = pointer.next;
        // }
        // //find target-1 element

        // len-=n;
        // pointer = dummy;
        // while(len>0){
        //     len--;
        //     pointer = pointer.next;
        // }
        // pointer.next = pointer.next.next;

        // return dummy.next;


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // Move fast pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Skip the nth node from the end
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
