import java.util.*;

/**
 * Created by i843719 on 10/31/14.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length <= 1)
            return null;
        //use a hashset to solve this questin might be good
        HashSet<Integer> set = new HashSet<Integer>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++){
            set.add(target - numbers[i] ); //add remain into set
        }
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < numbers.length; i++){
            if (set.contains(numbers[i])){
                index1 = i;
                System.out.println( "remain is"+numbers[i]);
                break;   // problem is because if the first found is half of the target
                        // then it is wrong, so we need to consider how to compare the i and the i in the above loop.
                        // to ensure they are not equal
            }
        }

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == target - numbers[index1]){
                if (index1 != i)
                    index2 = i;
            }
        }
        res[0] = index2+1;
        res[1] = index1+1;
        return res;
    }




    public List<String> fullJustify(String[] words, int L) {
        // if the wo
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0)
            return res;
        int i = 0;
        while (i < words.length){
            int start = i;
            int sum = 0;
            while(i < words.length && sum+ words[i].length()<=L){
                sum+=words[i].length() + 1; // add a space also
                i++;
            }
            int end = i-1;  // find the last one
            int intervalCount = end - start;
            int avgSp = 0, leftSp = 0;
            if (intervalCount > 0){  //has a space
                avgSp = (L - sum + intervalCount + 1)/intervalCount;  //intervalCount is the space number
                leftSp = (L - sum + intervalCount + 1)%intervalCount;
            }
            StringBuilder line = new StringBuilder();
            for (int j = start; j < end; j++){
                line.append(words[j]);
                if (i == words.length)
                    line.append(" ");
                else{
                    int k = 0;
                    while(k < avgSp){
                        line.append(" ");
                        k++;
                    }
                    if (leftSp > 0){
                        line.append(" ");
                        leftSp--;
                    }
                }
            }
            line.append(words[end]);
            if (line.length() < L){
                int e = 0;
                while(e < L - line.length()){
                    line.append(" ");
                    e++;
                }
            }
            res.add(new String(line));
        }
        return res;
    }


    ListNode sortList(ListNode head){
        if (head == null)
            return null;

        int len = 0;
        ListNode first = head;
        while(first != null){
            len++;
            first = first.next;
        }
        ListNode[] array = {head};
        ListNode newHead = sort(head, len);
        return newHead;
    }

    //divide the linkedlist
    ListNode sort (ListNode head, int length){
        if (length == 1)
        {
            ListNode temp = head;
            System.out.println(temp.val);
            head = head.next;  //get next
            temp.next = null;  //isolate the node, set next to null
            return temp;
        }// this is very important to to make its next become null.

        ListNode leftHead = sort(head, length/2);
        ListNode rightHead = sort(head, length- length/2);

        ListNode newHead = merge(leftHead, rightHead);
        return newHead;
    }
    ListNode merge(ListNode first, ListNode second){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(first != null || second != null)
        {
            int f = first == null ?  Integer.MAX_VALUE:first.val;
            int s = second == null? Integer.MAX_VALUE : second.val;
            if (f < s){
                cur.next = first;
                first = first.next;
            }
            else
            {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        cur = head.next;
        return cur;
    }


     public class TreeNode {
            int val;
           TreeNode left;
           TreeNode right;
            TreeNode(int x) { val = x; }
        }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();

        if (root == null){
            return result;
        }

        Stack<TreeNode> posStack = new Stack<TreeNode>();

        posStack.push(root);
        TreeNode prev = null;

        while(!posStack.isEmpty()){
            TreeNode cur = posStack.peek();
            //downside
            if (prev == null || prev.left == cur || prev.right == cur){
                if (cur.left != null)
                    posStack.push(cur.left);
                else if (cur.right != null)
                    posStack.push(cur.right);
            }else if(cur.left == prev){  //upside
                if (cur.right != null)
                    posStack.push(cur.right);
            }else{
                result.add(cur.val);   //no left element.
                posStack.pop();
            }
            prev = cur;
        }

        return result;
    }


    public void testIter(List<String> data){
        Iterator<String> ite = data.iterator();
        if (ite.hasNext()){
           System.out.println(ite.next());
           System.out.println(ite.next());
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comRes = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, comRes, 0, 0);
        return res;
    }
    void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> comRes, int curSum, int level){
        if (curSum > target)    return;
        if (curSum == target && comRes.size() != 0){
            res.add(new ArrayList<Integer>(comRes));
            return;
        }
        for (int i = level; i < candidates.length; i++){
            if (curSum + candidates[i] <= target){
                if(i>0 && candidates[i]==candidates[i-1])
                    continue;
                curSum += candidates[i];
                comRes. add(candidates[i]);
                dfs(candidates, target, res, comRes, curSum, i);
                comRes.remove(comRes.size() - 1);
                curSum -= candidates[i];
            }
        }
    }




//    int findMaxRepeating(int[] arr) {
//        int k = 8;
//        for (int i = 0; i < n; i++)
//            arr[arr[i] % k] += k;
//    }
}
