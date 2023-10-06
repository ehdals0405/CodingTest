package BaekJun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5464 {

    public static void main(String[] args) throws IOException {

        // N 주차 공간 단위 무게당 요금 줄 수
        // M 차량들의 무게 줄 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] Rs = new int[N + 1];
        int[] parking = new int[N + 1];
        int[] Wk = new int[M + 1];
        Queue<Integer> waiting = new LinkedList<>();

        // 요금 배열
        for (int i = 1; i <= N; i++) {
            Rs[i] = Integer.parseInt(br.readLine());
        }
        // 차 무게 배열
        for (int i = 1; i <= M; i++) {
            Wk[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;

        find:
        for (int i = 0; i < 2 * M; i++) {

            int carNum = Integer.parseInt(br.readLine());

            // 차번호가 양수면 입차
            if (carNum > 0) {
                // 주차장 빈자리 찾기
                for (int j = 1; j <= N; j++) {
                    if (parking[j] == 0) {
                        parking[j] = carNum;
                        continue find;
                    }
                }
                // 자리 없으면 대기순위에 넣기
                waiting.add(carNum);
            }
            // 음수면 출차
            else {

                for (int j = 1; j <= N; j++) {
                    if (parking[j] == carNum * -1) {
                        // 주차장 비우기
                        parking[j] = 0;
                        // 요금 계산
                        sum += Rs[j] * Wk[carNum * -1];
                        // 웨이팅 있으면 해당 자리에 넣기
                        if (!waiting.isEmpty()) {
                            parking[j] = waiting.poll();
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
