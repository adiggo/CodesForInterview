package Algorithm.Twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by i843719 on 12/17/14.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        
        String line1=null;

        while ((line1 = br.readLine()) != null){ //loop will run from 2nd line
            //some code
        }
    }

}
