package Algorithm.Leetcode;

import java.util.HashMap;

/**
 * Created by i843719 on 12/8/14.
 */
public class LRUCache {

    class DoubleLinkedList {
        public int val;
        public int key;
        public DoubleLinkedList pre;
        public DoubleLinkedList next;

        public DoubleLinkedList(int key, int value) {
            val = value;
            this.key = key;
        }
    }
    HashMap<Integer, DoubleLinkedList> map = new HashMap<Integer, DoubleLinkedList>();
    private DoubleLinkedList head, tail;
    private int capacity, len;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0; // initiate as 0, start from now
    }



    public int get(int key) {

        if (!map.containsKey(key)){  //O(1)
            return -1;
        }else{
            DoubleLinkedList cur = map.get(key);
            remove(cur);
            setHead(cur);
            return cur.val;
        }
    }


    private void remove(DoubleLinkedList node){
        DoubleLinkedList cur = node;
        DoubleLinkedList pre = cur.pre;
        DoubleLinkedList next = cur.next;
        //update pre and next
        //boudary case is that pre and tail are equal to null
        if(pre != null){
            pre.next = next;
        }else{
            head = next;
        }
        if (next != null){
            next.pre = pre;
        }else{
            tail = pre;
        }
    }


    private void setHead(DoubleLinkedList cur){
        cur.next = head;   //it does not constrained by boundary conditions
        cur.pre = null;   //head does not have a pre
        if (head != null){
            head.pre = cur;
        }

        head = cur;  // update head
        if (tail == null)
        {
            tail = cur;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedList changeNode = map.get(key);
            changeNode.val = value;  //set new value
            remove(changeNode);
            setHead(changeNode);
        }else{
            DoubleLinkedList insertNode = new DoubleLinkedList (key, value);
            if (len < capacity){
                setHead(insertNode);
                map.put(key, insertNode);
                len++;
            }else{
                map.remove(tail.key);
                //without constraint

                tail = tail.pre;    //
                if(tail != null){
                    tail.next = null;
                }
                setHead(insertNode);
                map.put(key, insertNode);

            }
        }
    }

}
