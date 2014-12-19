package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/8/14.
 */
public class SortList {
    public ListNode fakeHead;

    ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        fakeHead = head;
        int len = 0;
        ListNode first = head;
        while (first != null) {
            len++;
            first = first.next;
        }
        ListNode[] array = {head};
        ListNode newHead = sort(fakeHead, len);
        return newHead;
    }

    //divide the linkedlist
    ListNode sort(ListNode head, int length) {
        if (length == 1) {
            ListNode temp = head;
            head = head.next;  //get next
            temp.next = null;  //isolate the node, set next to null
            return temp;
        }// this is very important to to make its next become null.

        ListNode leftHead = sort(head, length / 2);
        ListNode rightHead = sort(head, length - length / 2);

        ListNode newHead = merge(leftHead, rightHead);
        return newHead;
    }

    ListNode merge(ListNode first, ListNode second) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (first != null || second != null) {
            int f = first == null ? Integer.MAX_VALUE : first.val;
            int s = second == null ? Integer.MAX_VALUE : second.val;
            if (f < s) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        cur = head.next;
        return cur;
    }
}
