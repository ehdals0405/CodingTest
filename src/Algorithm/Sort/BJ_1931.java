package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] meeting = new int[N][2]; // 회의 시간

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meeting[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }
        // 끝나는 시간으로 정렬하고 끝나는 시간이 같으면 시작시간으로 정렬
        Arrays.sort(meeting, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return  o1[1] - o2[1];
        });


        int count = 0;
        int endTime = 0;
        for (int i = 0; i < N; i++) {

            // 시작 시간이 끝나는 시간보다 크면 회의 참여 가능
            if(endTime <= meeting[i][0]){

                count++;
                // 시작한 회의의 끝나는 시간을 다시 할당
                endTime = meeting[i][1];
            }

        }
        System.out.println(count);
    }
}
