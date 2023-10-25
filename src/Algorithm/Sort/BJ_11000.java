package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11000 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] lectureList = new int[N][2];

        // 강의 정보 입력받기
        for (int i = 0; i < N; i++) {

            int[] lecture = new int[2];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lecture[0] = start;
            lecture[1] = end;

            lectureList[i] = lecture;
        }

        // 시작순으로 정렬, 시작시간이 같으면 종료시간으로 정렬
        Arrays.sort(lectureList, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        // 우선순위 큐에 종료 시간을 넣고 다음 강의 시작시간이 종료 시간보다 작으면
        // 강의실을 하나 더 써야하니까 종료 시간 하나 더 추가
        // 종료 시간과 시작 시간이 같거나 시작 시간이 더 크면 그 강의실 쓰면 됨
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 첫 강의
        queue.add(lectureList[0][1]);

        for (int i = 1; i < lectureList.length; i++) {

            // 끝나는 시간이 더 짧으면 앞의 강의 빼기
            if (queue.peek() <= lectureList[i][0]){
                queue.poll();
            }

            queue.add(lectureList[i][1]);
        }

        System.out.println(queue.size());
    }
}
