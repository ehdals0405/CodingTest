package Algorithm.Programmers;

import java.util.Stack;

public class PG_올바른괄호 {

    boolean solution(String s) {

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(') stack.push('(');
            else if(s.charAt(i) == ')'){
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }


        return stack.isEmpty();
    }
}
