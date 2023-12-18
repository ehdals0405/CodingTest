package Algorithm.Programmers;

import java.util.PriorityQueue;

public class PG_더맵게 {

    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        int answer = 0;

        while (queue.peek() < K) {

            if (queue.size() == 1) return -1;
            int mix = queue.poll() + queue.poll() * 2;
            queue.add(mix);
            answer++;
        }

        return answer;

    }
}
