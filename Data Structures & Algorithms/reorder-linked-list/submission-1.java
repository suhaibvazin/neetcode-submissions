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
    public void reorderList(ListNode head) {

        // find count of nodes,n/2 replacements is  needed

        //in second loop iterate through the node if the count is n-(n/2) break connection
        //now you will two linked list and exit
        //iterate both parallelly in a loop and insert things while small list is not null
        //and insert thins]gs from smaller list in main linked list

        // [0,1,2,3]
        // [4,5,6] 
        if(head==null){
            return;
        }
        int n =0;
        ListNode current = head;
        while(current!=null){
            n++;
            current = current.next;
        }
        //break at list at point
        int breakAfter = n-(n/2);
        current = head;
        ListNode smallhead = null;
        for (int i = 0; i < (n - 1) / 2; i++) { 
            current = current.next;
        }
        // Now current is sitting on Node 1.
        smallhead = current.next; // smallhead is now Node 2
        current.next = null;

        //reverse the small part
        ListNode prev = null;
        while(smallhead!=null){
            ListNode temp = smallhead.next;
            smallhead.next = prev;
            prev = smallhead;
            smallhead = temp;
        }

        
        // [0,1,2,3] //head
        // [4,5,6] //smallhead
        //merger
        current = head;
        smallhead = prev;
        while(smallhead!=null){
            ListNode headTemp = current.next;
            ListNode smallheadTemp = smallhead.next;
            current.next = smallhead;
            smallhead.next = headTemp;
            current = headTemp;
            smallhead = smallheadTemp;
        }  
    }
}
