package Algorithm.Leetcode;

import java.util.HashMap;

/**
 * Created by i843719 on 12/9/14.
 */
public class CopyListWithRandomPointer {
    class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        //copy use method which generate a new object

        if (head == null)
            return null;


        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);

        RandomListNode helper1 = head;
        RandomListNode helper2 = newHead;
        map.put(head, newHead);
        helper1 = helper1.next;
        while(helper1 != null){
            RandomListNode tmp = new RandomListNode(helper1.label);

            map.put(helper1, tmp);
            helper2.next = tmp;
            helper2 = helper2.next;
            helper1 = helper1.next;
        }   // get new next
        helper2.next = null;

        helper1 = head;
        helper2 = newHead;

        while(helper1 != null){
            if (helper1.random != null)
                helper2.random = map.get(helper1.random);
            else
                helper2.random = null;     //two boundary case need to be considered
            helper1 = helper1.next;
            helper2 = helper2.next;
        }
        return newHead;


    }
}
