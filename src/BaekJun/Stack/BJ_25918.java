package BaekJun.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_25918 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack();
        // 괄호 문자열 길이 N
        int N = Integer.parseInt(br.readLine());
        // 괄호 문자 배열
        char[] ch = br.readLine().toCharArray();
        int day = 0;

        for (int i = 0; i < N; i++) {

            char c = ch[i];
            // 괄호가 서로 다르면 스택에서 뺴기  => () 또는 )( 완성 아니면 넣기
            if (stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
            } else stack.pop();
            // 스택에 쌓인 괄호 갯수가 문자열을 만들기 위한 최대 필요한 날짜
            day = Math.max(day, stack.size());

        }
        // 스택이 전부 비워졌으면 날짜 출력 안비워지면 만들 수 없는 문자열이므로 -1 출력
        if (stack.isEmpty()) {
            System.out.println(day);
        } else System.out.println("-1");
    }
}
