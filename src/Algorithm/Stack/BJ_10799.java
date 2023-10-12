package Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack stack = new Stack();
        int piece = 0; // 조각 개수
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {

            // 열린 괄호는 계속 넣어줌
            if (s.charAt(i) == '(') {
                stack.push('(');
                continue;
            }
            // 닫힌 괄호가 나오면 두가지 경우의 수
            if (s.charAt(i) == ')') {

                stack.pop();
                // 만약 전 글자가 열린 괄호면 레이저 완성
                if (s.charAt(i - 1) == '(') {
                    // 열린 괄호 수 만큼 개수 추가
                    piece += stack.size();
                }
                // 닫힌 괄호면 작은 막대기 하나 그냥 완성된거라 조각 하나 추가
                else piece++;
            }
        }
        System.out.println(piece);
    }
}
