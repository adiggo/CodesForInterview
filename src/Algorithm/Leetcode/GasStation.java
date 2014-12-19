package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/10/14.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDiff = 0;
        int partDiff = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++){
            totalDiff += (gas[i] - cost[i]);
            partDiff += (gas[i] - cost[i]);
            if(partDiff < 0){
                if(i < gas.length - 1)
                    startIndex = i+1;
                partDiff  = 0;
            }
        }
        if(totalDiff < 0)
            return -1;
        else
            return startIndex;
    }
}
