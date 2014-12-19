package ServiceNow;

/**
 * Created by i843719 on 12/1/14.
 */
public class PrimeNum {
    boolean isPrime(int check){
        for (int i = 2; i < check/2; i++){
            if (check % i == 0){
                return false;
            }
        }
        return true;
    }
}
