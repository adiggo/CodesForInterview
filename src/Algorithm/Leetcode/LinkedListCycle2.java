package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/8/14.
 * This is actually solved by using a formular.
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode intersection = null;
        if(head == null)
            return intersection;
        ListNode fast = head;
        ListNode slow = head;

        while(slow != null){
            slow = slow.next;
            if (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
            }else{
                return intersection;
            }
            if(slow == fast){
                intersection = slow;
                break;
            }
        }

        slow = head;
        while(intersection != slow){
            intersection = intersection.next;
            slow = slow.next;
        }

        return intersection;

    }
}
