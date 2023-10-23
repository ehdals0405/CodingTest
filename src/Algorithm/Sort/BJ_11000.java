package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_11000 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 시작순으로 정렬, 시작시간이 같으면 종료시간으로 정렬
        // 다음 강의의 시작시간이 현재 강의 종료시간보다 작으면 강의실 1개 추가
        // 강의실 Max 치 갱신하기

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[][] lectureList = new int[N][2];
        int lectureRoom = 1;

        for (int i = 0; i < N; i++) {

            int[] lecture = new int[2];
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lecture[0] = start;
            lecture[1] = end;

            lectureList[i] = lecture;
        }

        Arrays.sort(lectureList, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int start = lectureList[0][0];
        int end = lectureList[0][1];

        for (int i = 1; i < lectureList.length; i++) {

            while (true) {
                int count = 1;
                int nextStart = lectureList[i][0];
                int nextEnd = lectureList[i][1];

                if (end > nextStart) count++;
                if (nextEnd > end)
                    end = nextEnd;
            }


        }
    }
}
