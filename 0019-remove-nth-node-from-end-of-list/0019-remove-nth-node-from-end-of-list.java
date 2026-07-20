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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s1 = head;
        ListNode s2 = head;

        for (int i = 0; i < n; i++) {
            s2 = s2.next;
        }

        if (s2 == null) {
            return head.next; // remove head
        }

        while (s2.next != null) {
            s1 = s1.next;
            s2 = s2.next;
        }

        s1.next = s1.next.next;

        return head;
    }
}