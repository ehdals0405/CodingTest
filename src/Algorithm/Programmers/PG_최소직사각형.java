package Algorithm.Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG_최소직사각형 {
    public static void main(String[] args) {

        PG_최소직사각형 pg_최소직사각형 = new PG_최소직사각형();
        System.out.println(pg_최소직사각형.solution(new int[][]{{60,50},{30,70},{60,30},{60,30},{80,40}}));
    }

    public int solution(int[][] sizes) {

        // 명함을 하나하나 비교하면서 가로 세로 최대치 갱신
        // 갱신할 때 가로로 해도 괜찮은지 확인하기
        int maxW = 0;
        int maxH = 0;


        for (int i = 0; i < sizes.length; i++) {

            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);

            maxW = Math.max(w, maxW);
            maxH = Math.max(h, maxH);
        }

        return maxH * maxW;
    }
}
