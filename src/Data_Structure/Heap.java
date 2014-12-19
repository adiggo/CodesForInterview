package Data_Structure;

/**
 * Created by i843719 on 11/12/14.
 */
public class Heap {
    private class HeapNode{
        int val;
        HeapNode left, right;
        public HeapNode(int val){
            this.val = val;
        }
    }

    private HeapNode root;
    public Heap(){
        root = null;
    }



}
