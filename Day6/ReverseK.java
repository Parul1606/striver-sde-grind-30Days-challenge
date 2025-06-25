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

    // Main function to reverse nodes in k groups
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Step 1: Check if there are at least k nodes ahead
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Step 2: If we have k nodes, reverse them
        if (count == k) {
            // Reverse first k nodes
            ListNode reversedHead = reverseKNodesHelper(head, k);

            // head is now the tail of the reversed group
            // Recursively process the next part of the list and connect
            head.next = reverseKGroup(curr, k);

            // Return the new head of this reversed group
            return reversedHead;
        }

        // Step 3: If less than k nodes are left, no reversal — return as is
        return head;
    }

    // Helper function to reverse exactly k nodes
    private ListNode reverseKNodesHelper(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;

        // Reverse k nodes using typical reverse logic
        while (curr != null && count < k) {
            next = curr.next;     // store next node
            curr.next = prev;     // reverse the pointer
            prev = curr;          // move prev to current
            curr = next;          // move current to next
            count++;
        }

        // Return new head of reversed part (prev is the new head)
        return prev;
    }
}
