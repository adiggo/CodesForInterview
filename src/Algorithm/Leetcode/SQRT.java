package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/9/14.
 */
public class SQRT {
    public int sqrt(int x) {
        //divide conquer
        if (x < 0)
            return -1;
        if (x == 1)
            return 1;
        // we need to return a integer which may simplify the problem.
        // log n

        long start = 0;
        long end = x/2 + 1;  //maximum
        while(start <= end){
            long mid = start + (end - start)/2;
            if (mid * mid > x){
                end = mid - 1;
            }else if (mid * mid < x){
                start = mid + 1;
            }else if (mid * mid == x)
                return (int) mid;
        }
        return (int) end;
    }
}
