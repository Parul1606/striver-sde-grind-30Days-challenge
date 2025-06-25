package Day6;

class Solution {
    public boolean isPalindrome(ListNode head) {
        // Step 1: Initialize two pointers to find the middle of the list
        ListNode slow = head, fast = head, prev, temp;

        // Step 2: Move slow by 1 step and fast by 2 steps to reach mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Cut the list in half
        prev = slow;            // prev now points to middle
        slow = slow.next;       // move slow to second half start
        prev.next = null;       // break the list into two halves

        // Step 4: Reverse the second half of the list
        while (slow != null) {
            temp = slow.next;   // store next node
            slow.next = prev;   // reverse the link
            prev = slow;        // move prev forward
            slow = temp;        // move slow forward
        }

        // Step 5: Compare first half and reversed second half
        fast = head;            // reset fast to head (start of first half)
        slow = prev;            // slow now points to start of reversed second half

        while (slow != null) {
            if (fast.val != slow.val) return false; // mismatch
            fast = fast.next;
            slow = slow.next;
        }

        // Step 6: If no mismatch found, it's a palindrome
        return true;
    }
}
