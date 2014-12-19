package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/7/14.
 * LinkedList
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        //each time update head
        //so there is no need to keep original head, since it is maybe nowhere in next iteration

        ListNode fakeHead = new ListNode(-1);
        //ListNode pre = fakeHead; // this should not be initiated with head
        ListNode pre = fakeHead;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            pre = fakeHead; // call it each iteration. Cause in each iteration, we need to set it as fakeHead;
            // get the rigth insertion spot
            while (pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            // insert cur before pre.next and after pre.
            cur.next = pre.next;  // set cur.next to null
            pre.next = cur;  // change a null node to cur

            cur = next;// update cur as next
        }
        return fakeHead.next;
    }
}