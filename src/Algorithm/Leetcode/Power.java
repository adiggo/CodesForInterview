package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/9/14.
 */
public class Power {
    public double pow(double x, int n) {
        // divide , binary
        // if n is not positive
        if (n < 0){
            return 1/power(x, -n);
        }else{
            return power(x, n);
        }
    }

    private double power(double x, int n){
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double value = pow(x, Math.abs(n/2));
        return n%2 == 1? value * value *x : value * value;  // detect whether n is odd or even
    }
}
