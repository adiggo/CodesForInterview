package Algorithm.Twitter;

import junit.framework.Assert;

import java.util.Arrays;

/**
 * Created by i843719 on 12/17/14.
 */
public class FindShortestDistanceBetweenPairs {
    public int getMin(int[] A){

        Assert.assertTrue(A.length >= 2);
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++){
            int tmp = A[i] - A[i-1];
            if (min > tmp){
                min = tmp;
            }
        }

        return min;

    }

}
