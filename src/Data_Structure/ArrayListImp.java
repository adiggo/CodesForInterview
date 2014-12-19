package Data_Structure;

import java.util.Arrays;

/**
 * Created by i843719 on 11/4/14.
 */
public class ArrayListImp<T> {

    private T[] mystore;
    private int actSize = 0;
    private static final int DEFAULT_CAP = 10;

    public ArrayListImp(){
        this(DEFAULT_CAP);
    }

    public ArrayListImp(int capacity){
        if (capacity < 0)
            throw new IllegalArgumentException();
        mystore = (T[])new Object[capacity];  //force convert type
    }

    public T get(int index){
        if (index < actSize){
            return mystore[index];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(T t){
        if (mystore.length - actSize < 5){
            increaseListSize();
        }else{
            mystore[actSize++] = t;   // store the element into the corresponding index
        }
    }

    private void increaseListSize() {
        mystore = Arrays.copyOf(mystore, mystore.length * 2);  //copy into a new length array
    }


    public int size(){
        return actSize;
    }


    public void remove(int index){
        if (index >= actSize){

            throw new ArrayIndexOutOfBoundsException();

        }else{
            T t = mystore[index];
            mystore[index] = null;
            int tmp = index;
            while(tmp < actSize){
                mystore[tmp] = mystore[tmp+1];
                mystore[tmp+1] = null;
                tmp++;
            }
            actSize--;
        }
    }




}
