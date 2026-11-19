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
    public ListNode rotateRight(ListNode head, int k) {
        // 空链表或只有一个节点，无需旋转
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. 求链表长度，并找到尾节点
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. 取模，避免多余旋转
        k %= len;
        if (k == 0) return head;

        // 3. 成环
        tail.next = head;

        // 4. 找到新的尾节点：从 head 走 len - k - 1 步
        ListNode newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        // 5. 断开环，返回新的头节点
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}