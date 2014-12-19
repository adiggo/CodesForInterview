package GuideWire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by i843719 on 12/7/14.
 * Two method to solve this problem.
 * First approach is to use recursion
 * Second approach is to use bit manipulation.
 * Third approach is to use iteration
 */
public class PowerSet {
    public List<List<Integer>> getPowerSet(int[] A) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>()); // initial empty added into 
        dfs(A, 0, res, new ArrayList<Integer>());
        return res;
    }

    void dfs(int[] A, int curindex, List<List<Integer>> res, List<Integer> curRes) {
//        if (curindex == A.length)
//            return;
        for (int i = curindex; i < A.length; i++) {
            curRes.add(A[i]);
            res.add(new ArrayList<Integer>(curRes));
            if (i < A.length - 1)
                dfs(A, i + 1, res, curRes);
            curRes.remove(curRes.size() - 1);
        }
    }

    public List<List<Integer>> getPowerSetByBitManipulation(int[] A) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < Math.pow(2, A.length); i++) {
            List<Integer> curRes = new ArrayList<Integer>();
            for (int j = 0; j < 32; j++) {
                if (getCurBit(i, j) == 1) {
                    curRes.add(A[j]);
                }
            }
            res.add(curRes);
        }
        return res;
    }

    private int getCurBit(int b, int i) {
        return b >> i & 1;
    }
    public static <T> List<List<T>> powerset(Collection<T> list) {
        List<List<T>> ps = new ArrayList<List<T>>();
        ps.add(new ArrayList<T>());   // add the empty set

        // for every item in the original list
        for (T item : list) {
            List<List<T>> newPs = new ArrayList<List<T>>();

            for (List<T> subset : ps) {
                // copy all of the current powerset's subsets
                newPs.add(subset);

                // plus the subsets appended with the current item
                List<T> newSubset = new ArrayList<T>(subset);
                newSubset.add(item);
                newPs.add(newSubset);
            }

            // powerset is now powerset of list.subList(0, list.indexOf(item)+1)
            ps = newPs;
        }
        return ps;
    }
}
