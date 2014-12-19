package Data_Structure;

import java.util.Arrays;

/**
 * Created by i843719 on 11/4/14.
 */
public class QueueImp<T> {

    // two method use array to implement or use list to implement

    private T[] arr;
    private int actSize, first, next;  // first and next are both index

    public QueueImp(){
        arr = (T[]) new Object[10];
    }

    private void resize(int size){
        Arrays.copyOf(arr, size);
    }

    private void enqueue(T t){
        if (arr.length == actSize){
            resize(arr.length * 2);
        }
        arr[next++] = t;
        if (next == arr.length) next = 0;
        actSize++;
    }



}
