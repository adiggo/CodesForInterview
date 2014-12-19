package Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by i843719 on 12/8/14.
 */
public class WordBreak2 {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if (s == null) {
            return result;
        }
        StringBuilder helper = new StringBuilder();
        boolean[] possible = new boolean[s.length() + 1];
        for (int i = 0; i < possible.length; i++) {
            possible[i] = true;  //possible means from the current location to end is possible to be divided by the dict
        }
        dfs(s, dict, 0, result, helper, possible);
        return result;
    }

    void dfs(String s, Set<String> dict, int startIndex, List<String> result, StringBuilder helper, boolean[] possible) {
        if (startIndex == s.length()) {
            result.add(new String(helper));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String component = s.substring(startIndex, i + 1);
            int oldSize = result.size();
            if (dict.contains(component) && possible[i + 1]) {  //at first we all set possible array as true
                int oldLength = helper.length();
                if (helper.length() > 0)
                    helper.append(" ");
                helper.append(component);
                dfs(s, dict, startIndex + component.length(), result, helper, possible);
                // this decide whether the
                if (result.size() == oldSize)
                    possible[i + 1] = false;
                helper.delete(oldLength, helper.length()); // revert the stringbuilder
            }
        }
    }
}
