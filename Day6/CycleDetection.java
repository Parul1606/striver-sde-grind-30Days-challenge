package Day6;

public class Solution {
    public boolean hasCycle(ListNode head) {
        // Step 1: Initialize two pointers
        ListNode slow = head;
        ListNode fast = head;

        // Step 2: Traverse list with 2 speeds
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move by 1
            fast = fast.next.next;      // Move by 2

            if (slow == fast) {
                return true;            // They meet → cycle exists
            }
        }

        return false;  // fast reached end → no cycle
    }
}
