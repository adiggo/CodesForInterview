package Algorithm.Leetcode;

import java.util.Stack;

/**
 * Created by i843719 on 12/8/14.
 * Stack
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        int returnValue = 0;

        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                    case 0:
                        stack.push(Integer.toString(a + b));
                        break;
                    case 1:
                        stack.push(Integer.toString(b - a));
                        break;
                    case 2:
                        stack.push(Integer.toString(b * a));
                        break;
                    case 3:
                        stack.push(Integer.toString(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;

    }


}
