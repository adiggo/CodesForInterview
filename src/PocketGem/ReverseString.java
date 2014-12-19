package PocketGem;

/**
 * Created by i843719 on 12/3/14.
 */
public class ReverseString {
    public String reverse(String s){
        char[] input = s.toCharArray();

        int start = 0, end = s.length() -1;
        while(start <= end){
            char tmp = input[start];
            input[start] = input[end];
            input[end] = tmp;
        }

        return new String(input);
    }
}
