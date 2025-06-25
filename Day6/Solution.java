package Day6;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Edge case
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Traverse both lists
        while (a != b) {
            // If one pointer reaches end, move it to the other list's head
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        // They either meet at intersection or both become null (no intersection)
        return a;
    }
}
