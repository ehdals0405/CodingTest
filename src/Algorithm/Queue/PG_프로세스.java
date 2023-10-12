package Algorithm.Queue;

import java.util.*;

public class PG_프로세스 {

    public static void main(String[] args) {

        int result = solution(new int[]{1,1,9,1,1,1}, 0);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {


        // 큰 숫자가 우선수위가 제일 높으므로 내림차순으로 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : priorities) {
            queue.add(num);
        }
        // 프로세스 종료 순서
        int answer = 0;

        while (!queue.isEmpty()) {

            for (int i = 0; i < priorities.length; i++) {
            // 우선순위 높은 순서대로 프로세스를 하나씩 처리
                if (priorities[i] == queue.peek()) {
                    queue.poll();
                    answer++;
                    if(i == location)
                        return answer;
                }
            }
        }
        return answer;
    }
}
