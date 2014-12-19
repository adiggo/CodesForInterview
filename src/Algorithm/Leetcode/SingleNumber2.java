package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/9/14.
 */
public class SingleNumber2 {
    public int singleNumber(int[] A) {
        if (A==null||A.length==0){
            return -1;
        }

        int[] bits=new int[32];
        int result=0;
        for (int i = 0; i < 32; i++){
            for (int j = 0; j < A.length; j++){
                bits[i] += A[j]>>i & 1;
            }
            result |= (bits[i]%3) << i;
        }
        return result;
    }
}
