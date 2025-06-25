class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len == n) {
            return head.next;
        }
        temp = head;
        for (int i = 0; i < len - n - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        //5-2+1=4 that means 4th index..

        return head;
    }
}