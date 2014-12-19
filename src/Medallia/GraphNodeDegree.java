package Medallia;

import java.util.*;

/**
 * Created by i843719 on 12/1/14.
 */
public class GraphNodeDegree {
    private class Node{
        public int val;
        public boolean visited;
        public List<Node> neighbors;
    }
    // from a single source
    public Map<Integer, Integer> getAllDegree(Node root){
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        // do a bfs
        // traverse the whole graph, get all degree
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node subRoot = queue.poll();
            for (Node subchildren: subRoot.neighbors){
                if (subchildren.visited == false){
                    queue.add(subchildren);
                    subchildren.visited = true;
                }
            }
            if (res.containsKey(subRoot.neighbors.size()))
                res.put(subRoot.neighbors.size(), res.get(subRoot.neighbors.size())+1);
        }
        return res;
    }


    private static Map<Integer, Integer> calculateDegreeCount(Node node) {
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        Set<Node> visited = new HashSet<Node>();
        // do a bfs
        // traverse the whole graph, get all degree
        Queue<Node> queue = new LinkedList<Node>();
        visited.add(node);
        queue.add(node);
        while(!queue.isEmpty()){
            Node subRoot = queue.poll();
            for (Node subchildren: subRoot.neighbors){
                if (!visited.contains(subchildren)){
                    queue.add(subchildren);
                    visited.add(subchildren);
                }
            }

            if (res.containsKey(subRoot.neighbors.size()))
                res.put(subRoot.neighbors.size(), res.get(subRoot.neighbors.size())+1);
            else
                res.put(subRoot.neighbors.size(), 1);
        }
        return res;
    }

}
