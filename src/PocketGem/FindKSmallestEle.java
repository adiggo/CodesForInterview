package PocketGem;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by i843719 on 12/4/14.
 */
public class FindKSmallestEle {
    public int getSmall(int[] data, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(16, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else if (o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });
        // max heap --> O(k)
        // if element smaller than it, insert it into heap, heapify
        
        for (int i = 0; i < data.length-k; i++){
            heap.add(data[i]);
        }
        heap.add(1);
        heap.poll();
        return 1;
    }
}
