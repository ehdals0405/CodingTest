package Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10773 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // K개의 정수 줄
        int K = Integer.parseInt(br.readLine());

        Stack stack = new Stack();

        while (K-- > 0) {

            int num = Integer.parseInt(br.readLine());
            // 0이면 전 꺼 빼기
            if (num == 0) stack.pop();
            // 0 아니면 넣기
            else stack.push(num);
        }

        // 합 구하기
        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            while (!stack.isEmpty()) {
                int num = (int) stack.pop();
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
