package BaekJun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_12873 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue queue = new LinkedList();

        // 사람 인원수 만큼 큐에 넣기
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 문제에서 조건
        int index = 1;

        while (queue.size() != 1) {
            // index 3제곱 -1 만큼 움직임 -> 해당 인원을 제외했을 때 바로 다음 사람으로 넘어가기 떄문
            long pow = (long) (Math.pow(index, 3) - 1);
            long count = pow % queue.size();
            // 움직일 횟수 / 사람 인원수 한 나머지 만큼 사람을 큐에서 뺏다가 다시 넣음
            for (int i = 0; i < count;i++) {
                queue.add(queue.poll());
            }
            // 경품 받을 사람을 제외
            queue.poll();
            // 조건 +1
            index++;
        }
        // 경품을 받을 사람을 사람 한명 남을 때 까지 반복하고 출력
        System.out.println(queue.peek());

    }
}
