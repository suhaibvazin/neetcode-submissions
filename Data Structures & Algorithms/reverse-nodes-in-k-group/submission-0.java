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
     public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes remaining
        ListNode check = head;
        int count = 0;
        while (check != null && count < k) {
            check = check.next;
            count++;
        }
        // If fewer than k nodes remain, return head as-is
        if (count < k) return head;

        // Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // head is now the tail of the reversed group
        // Recursively reverse the next group and connect
        head.next = reverseKGroup(curr, k);

        return prev; // prev is the new head of this reversed group
    }
}
