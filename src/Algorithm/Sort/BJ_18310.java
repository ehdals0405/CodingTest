package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18310 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 집들 중 중앙에서 왼쪽에 있는 거 고르면 될 거 같은데

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        int[] house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);

        int result;
        // 짝수일 경우 한칸 왼쪽에 있는 집 고르기
        if(  N % 2 == 0 ) result = house[N/2 -1];
        else result = house[N/2];

        System.out.println(result);

    }
}
