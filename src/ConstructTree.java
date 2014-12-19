/**
 * Created by i843719 on 12/14/14.
 */
public class ConstructTree {




    boolean isValid(int[] A){
        int preIndex = 0;
        return constructTree(A, preIndex, A[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean constructTree(int[] A, int preIndex,int key, int min, int max){
        if (preIndex >= A.length){
            return true;
        }
        if (key > min && key < max){
            preIndex = preIndex + 1;
            if (preIndex < A.length){
                return constructTree(A, preIndex, A[preIndex], key, max);
            }
        }else{
            return false;
        }
        return false;
    }
}
