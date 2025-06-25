class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        // Base case: if head is null or there's no next, return head
        if (head == null || head.next == null) return head;

        // Step 1: Recursively flatten the rest of the list
        head.next = flattenLinkedList(head.next);

        // Step 2: Merge current 'child' list with already flattened next list
        head = merge(head, head.next);

        // Step 3: Make sure next pointers are removed
        head.next = null;

        return head;
    }

    // Merge two sorted lists connected via 'child'
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);  // Dummy node to ease merging
        ListNode temp = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }
            temp = temp.child;
        }

        // Attach remaining nodes
        if (a != null) temp.child = a;
        else temp.child = b;

        return dummy.child; // Return merged head (skip dummy node)
    }
}
