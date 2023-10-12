package Algorithm.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class PG_다리를지나가는트럭 {
    public static void main(String[] args) {

        int result = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        // 다리 큐
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int bridgeSum = 0;

        for (int i = 0; i < truck_weights.length; i++) {

            while (true) {
                int truck = truck_weights[i];

                // 다리가 비어있을 때
                if (bridgeSum == 0) {

                    bridge.add(truck);
                    bridgeSum += truck;
                    time++;
                    break;
                    // 다리가 꽉찼을 때
                } else if (bridge.size() == bridge_length) {

                    bridgeSum -= bridge.poll();
                    // 다리가 차가 하나라도 있을 시
                } else {

                    // 다음 트럭으로 무게초과가 될 시
                    if (bridgeSum + truck > weight){

                        bridge.add(0);
                        time++;

                    }else {

                        bridge.add(truck);
                        bridgeSum += truck;
                        time++;
                        break;
                    }
                }

            }

        }

        // 마지막 트럭 통과 시간
        int answer = time+bridge_length;
        return answer;
    }
}
