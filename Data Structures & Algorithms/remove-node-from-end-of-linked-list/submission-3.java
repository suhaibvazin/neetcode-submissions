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
        //find length
        ListNode pointer = head;
        int  len = 0;
        while(pointer!=null){
            len++;
            pointer = pointer.next;
        }
        //find target element length+1-n
        int target = len+1-n;   
        //while iterating if cursor==target
        //if(pointer.next!=null) prev.next = pointer.next;
        //else return null;
        int cursor =1;
        pointer = head;
        ListNode prev = null;
        while(pointer!=null){
            if(cursor==target){
                if(pointer.next !=null || prev!=null)
                {
                    if(prev==null){
                        return pointer.next;
                    }
                    prev.next = pointer.next;
                }else{
                    return null;
                }
            }
            cursor++;
            prev = pointer;
            pointer = pointer.next;
        }
        return head;

    }
}
