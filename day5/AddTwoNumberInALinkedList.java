class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to simplify edge cases (e.g., first node addition)
        ListNode dummyHead = new ListNode(0);

        // Tail points to the last node of the result list
        ListNode tail = dummyHead;

        // To hold the carry after summing two digits
        int carry = 0;

        // Traverse both lists until both are null and no carry remains
        while (l1 != null || l2 != null || carry != 0) {

            // Get the current digits or 0 if the list has ended
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            // Add digits along with carry
            int sum = digit1 + digit2 + carry;

            // Extract last digit of sum to store in the node
            int digit = sum % 10;

            // Update carry (either 0 or 1)
            carry = sum / 10;

            // Create new node with the result digit and attach it
            ListNode newNode = new ListNode(digit);
            tail.next = newNode;

            // Move tail to the new last node
            tail = tail.next;

            // Move to the next nodes if they exist
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        // Final result is the list starting after dummy head
        ListNode result = dummyHead.next;

        // (Optional) Disconnect dummy head from result for cleanliness
        dummyHead.next = null;

        return result;
    }
}