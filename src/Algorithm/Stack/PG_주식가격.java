package Algorithm.Stack;

import java.util.Arrays;
import java.util.Stack;

public class PG_주식가격 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{1,3,4})));

    }

    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();

        // 몇 초 동안 가격이 안떨어지고 버티는지?
        for (int i = 0; i < prices.length; i++) {

            // 가격이 떨어지면 = (현재 가격 < 최근 가격)면  -> 현재 인덱스 - 최근 인덱스 값 =(버틴 시간) 배열에 저장
            // 마지막 인덱스값이 아니면 최소 1초는 버티기 때문
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        // 스택에 남아있는 인덱스 값은 가격이 한 번도 안 떨어진 주식
        while (!stack.isEmpty()) {

            // 배열 길이 - 인덱스 값 - 1 을 배열에 저장 [1,3,4] 면 [2,1,0]
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}
