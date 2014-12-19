package Algorithm.Leetcode;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by i843719 on 12/8/14.
 */
public class MaxPointInALine {

    public int maxPoints(Point[] points) {

        if (points == null || points.length == 0)
            return 0;
        if (points.length == 1)
            return 1;
        int res = 1;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            map.put((double) Integer.MIN_VALUE, 1);  // initialize with 1, since each time at least one node
            int dup = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;   //jump out of the for loop
                }
                double key = points[i].x == points[j].x ? (double) Integer.MAX_VALUE : (double) (0.0 + (points[i].y - points[j].y) / (double) (points[i].x - points[j].x));
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1); //overwrite
                } else {
                    map.put(key, 2); //second state is 2
                }
            }
            for (Integer k : map.values()) {
                if (res < k + dup) {
                    res = k + dup;
                }
            }
        }
        return res;

    }

}
