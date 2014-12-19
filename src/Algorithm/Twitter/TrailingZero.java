package Algorithm.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by i843719 on 12/17/14.
 */
public class TrailingZero {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int number = 0;
        while((line = br.readLine()) != null){
            number = Integer.parseInt(line);
        }
        System.out.println(getTrail(number));
    }


    public static int getTrail(int number){
        int div = 5;
        int res = 0;
        while(number / div >= 1){
            res += number/div;
            div *= 5;
        }
        return res;
    }
}
