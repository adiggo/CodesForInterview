package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/8/14.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
        ListNode cur = head;
        ListNode fast = head;
        // get the break node, actually it's the mid node
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            cur = cur.next;
        }
        ListNode current = cur.next;
        cur.next = null; //break the list

        ListNode root2 = revert(current);
        ListNode p2 = root2;
        ListNode p1 = head;
        while (p2 != null) {
            ListNode next = p1.next;
            ListNode newRootNext = p2.next;
            p1.next = p2;
            p2.next = next;
            p2 = newRootNext;
            p1 = next;
        }
    }


    /**
     * Revert the head, use a pre and cur. Return pre, since curr right now is null
     *
     * @param head
     * @return
     */
    public static ListNode revert(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        // set head node's next
        head.next = null;

        return pre;
    }
}
