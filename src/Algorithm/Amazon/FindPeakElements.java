package Algorithm.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i843719 on 11/22/14.
 */
public class FindPeakElements {

    public List<Integer> getPeaks(int[] input){
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length == 0)
            return res;
        int prev = Integer.MIN_VALUE;
        int cur = input[0];
        int i = 0;
        for (i = 0; i < input.length-1; i++){
            if (input[i] >= prev && input[i] >= input[i+1]){
                res.add(input[i]);
            }
            prev = input[i];  //update prev each time
        }
        if (input[i] >= prev){  // this is the last element
            res.add(input[i]);
        }
        return res;
    }

    public int findAPeak(int[] data, int start, int end){
        int mid = start + (end - start)/2;
        if (mid == 0 && data[mid+1] <= data[mid]){
            return mid;
        }
        if (mid == data.length-1 && data[mid] >= data[mid-1]){
            return mid;
        }
        if (data[mid] >= data[mid-1] && data[mid] >= data[mid+1])
            return mid;
        if (data[mid] < data[mid+1]){
            return findAPeak(data, mid+1, end);
        }
        if (data[mid] < data[mid -1]){
            return findAPeak(data, start, mid-1);
        }
        return 0;
    }




}
