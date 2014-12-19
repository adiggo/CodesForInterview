package Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by i843719 on 12/10/14.
 */
public class PowerSet {
    public List<List<Integer>> iterative(Set<Integer> set){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer i : set){
            List<List<Integer>> tmpRes = new ArrayList<List<Integer>>();
            for (List<Integer> subset: res){
                tmpRes.add(subset);
                List<Integer> newSubset = new ArrayList<Integer>();
                newSubset.add(i);
                tmpRes.add(newSubset);
            }
            res = tmpRes;
        }
        return res;
    }
}
