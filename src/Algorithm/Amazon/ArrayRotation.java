package Algorithm.Amazon;

/**
 * Created by i843719 on 11/26/14.
 */
public class ArrayRotation {
    // there are three method
    // the first one is to use additional space to record the value
    // the second one is to rotate one by one, no additinal array need to be used.
    // both of these method mentioned above are not good enough,
    // there is another method --> juggling method which only use O(n)time and O(1) additional space
    // Also we can first reverse o to k-1 and then reverse k to n-1 and then reverse the whole array
    void leftRotate(int[] arr, int d){
        int i, j, k , temp;
        // 1, 2, 3 , 4, 5 ,6 ,7
        for (i = 0; i < gcd(d, arr.length); i++){
            temp = arr[i];
            j = i;
            while(true){
                k = j+d;
                if (k >= arr.length)
                    k = k-arr.length;  //8-7 = 1
                if (k == i)
                    break;
                arr[j] = arr[k];  // arr[6] = arr[1] --> arr[6] = 2
                j = k; // j = 1

            }
            arr[j] = temp;
        }
    }

    //great common divisor
    int gcd(int x, int y){ //6 and 9
        if (y == 0)
            return x;
        else
            return gcd(y, x%y);    // 9, 6 ---- 9, 3 --- 3, 0
    }
}
