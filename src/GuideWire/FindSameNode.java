package GuideWire;

import java.util.List;

/**
 * Created by i843719 on 12/9/14.
 */
public class FindSameNode {
    public class Node{
        List<Node> children;
        int val;
    }

    public int findMostNearestNode(List<Node> list1, List<Node> list2){
        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i) == list2.get(i))
                return 0;
        }
        return 0;
    }










}
