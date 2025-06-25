package Day6;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect the cycle using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move 1 step
            fast = fast.next.next;      // move 2 steps

            if (slow == fast) {         // cycle detected
                // Step 2: Find the cycle's entry point
                slow = head;            // move slow to head
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;            // the start of the cycle
            }
        }

        // No cycle
        return null;
    }
}