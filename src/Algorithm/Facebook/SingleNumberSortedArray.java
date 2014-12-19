package Algorithm.Facebook;

/**
 * Created by i843719 on 11/4/14.
 */
public class SingleNumberSortedArray {
    public int findIndex(int[] A) {
        if (A == null || A.length == 0)
            return -1;
        int start = 0;
        int end = A.length - 1;
        if (A.length == 1)
            return A[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // consider mid -1 or  mid + 1 is out of bound
            if (mid < 1)
                return A[mid];
            else if (mid + 1 == A.length)
                return A[mid];   // if not found during the process, then the last digit must be.

            if (A[mid] == A[mid - 1] || A[mid] == A[mid + 1]) {
                int startIndex = A[mid] == A[mid - 1] ? mid - 1 : mid;
                if (startIndex % 2 == 1) {
                    start = startIndex + 2; // since the mid == mid+1 value
                } else {
                    end = startIndex - 1;
                }
            } else {
                return A[mid];
            }

        }
        return -1;    // if there is not single number, return -1
    }
}
