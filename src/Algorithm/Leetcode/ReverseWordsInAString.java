package Algorithm.Leetcode;

/**
 * Created by i843719 on 12/8/14.
 */
public class ReverseWordsInAString {


    public String reverseWords(String s) {
        //edge case
        if (s == null || s.length() == 0) {
            return s;
        }
        //  s = s.trim();
        StringBuilder result = new StringBuilder();

        int start, end;

        for (int i = s.length() - 1; i >= 0; i--) {

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            //edge case check
            if (i < 0)
                break;

            start = i;
            end = i;

            while (i >= 0 && s.charAt(i) != ' ') {
                end = i;
                i--;
            }
            // the first place should not be appended a space
            if (result.length() > 0)
                result.append(' ');

            for (int j = end; j <= start; j++) {
                result.append(s.charAt(j));  //append char into
            }

        }
        return result.toString();
    }

}
