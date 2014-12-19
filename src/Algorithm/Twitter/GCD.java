package Algorithm.Twitter;

/**
 * Created by i843719 on 12/17/14.
 */
public class GCD {
    
    public static int gcd(int a, int b){
        int c;
        if (a > b){
            if (a % b == 0)
                return b;
            else
                return gcd(b, a%b);
        }else if (b > a){
            if (b % a == 0)
                return a;
            else
                return gcd(a, b%a);
        }else{
            return a;
        }
    }

    public static void main(String[] args){
        System.out.println(gcd(10, 3));
    }
}
