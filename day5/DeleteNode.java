class Solution {
    public void deleteNode(ListNode node) {
        // Step 1: Store the next node (the one whose value we’ll copy)
        ListNode nd = node.next;

        // Step 2: Copy the value of the next node into the current node
        node.val = nd.val;

        // Step 3: Skip the next node in the list
        node.next = nd.next;

        // Step 4: (Optional) Disconnect the deleted node from memory
        nd.next = null;
    }
}
