package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // 케이스
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            // 지원자 수
            int N = Integer.parseInt(br.readLine());
            // 지원자 등수 배열
            int[][] applicant = new int[N][2];

            for (int j = 0; j < N; j++) {

                st = new StringTokenizer(br.readLine(), " ");
                // 지원자 등수
                int[] applicantGrade = new int[2];
                // 각각의 성적을 int 배열로 넣고 저장
                applicantGrade[0] = Integer.parseInt(st.nextToken());
                applicantGrade[1] = Integer.parseInt(st.nextToken());

                applicant[j] = applicantGrade;
            }

            // 하나의 성적으로 내림차순 정렬
            Arrays.sort(applicant, (o1, o2) -> o1[0] - o2[0]);

            // 가장 서류 등수가 높은 사람은 무조건 합격
            int count = 1;
            // 현재 합격한 사람들 중 면접 등수가 제일 낮은 사람을 기준
            int rank = applicant[0][1];

            // 2등부터 시작
            for (int j = 1; j < N; j++) {
                // 면접 등수 높으면 = 숫자가 낮으면 합격
                if (applicant[j][1] < rank) {
                    count++;
                    // 높은 등수로 바꾸기
                    rank = applicant[j][1];
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
