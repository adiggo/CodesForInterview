package ShopRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by i843719 on 12/7/14.
 */
public class TwoSum {
// HashMap
    // not memory efficient compare to BST
    public List<int[]> getCom(int[] data, int target){
        List<int[]> res = new ArrayList<int[]>();
        if (data == null || data.length == 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < data.length; i++){
            if (!map.containsKey(data[i])){
                map.put(target - data[i], i);
            }else{
                int[] sums = new int[2];
                sums[0] = map.get(data[i]);
                sums[1] = i;
                res.add(sums);
            }
        }
        return res;
    }

}
