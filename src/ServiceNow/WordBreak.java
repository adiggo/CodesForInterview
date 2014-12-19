package ServiceNow;

import java.util.Set;

/**
 * Created by i843719 on 12/1/14.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] divisible = new boolean[s.length() + 1];
        divisible[0] = true;


        for (int i = 0; i < s.length(); i++){

            if (!divisible[i]){
                continue;
            }

            for(String dictString : dict){
                int stringLength = dictString.length();
                int end = stringLength + i;
                if (end > s.length()){
                    continue;
                }
                //here should be as i+1, but since i is already plus one since we have assigned the first value as true
                if (s.substring(i, end).equals(dictString)){
                    divisible[end] = true;
                    if(end == s.length())
                        break;
                }

            }


        }

        return divisible[s.length()];

    }

}
