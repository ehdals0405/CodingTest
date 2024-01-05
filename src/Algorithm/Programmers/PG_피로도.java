package Algorithm.Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG_피로도 {

    static int answer = 0;
    static boolean[] isVisited;

    public static void main(String[] args) {
        PG_피로도 pg_피로도 = new PG_피로도();
        System.out.println(pg_피로도.solution(80,new int[][]{{80,20},{50,40},{30,10}}));
    }

    public int solution(int k, int[][] dungeons) {
        // 던전 -> 피로도 사용
        // 탐험시작 -> 최소 필요 피로도
        // 탐험마침 -> 소모 피로도
        // 최대한 많이 탐험


        isVisited = new boolean[dungeons.length];

        dfs(dungeons, k, 0);

        return answer;

    }

    public void dfs(int[][] dungeons, int k, int count) {

        for (int i = 0; i < dungeons.length; i++) {

            if (!isVisited[i] && k >= dungeons[i][0]) {
                isVisited[i] = true;
                dfs(dungeons, k - dungeons[i][1], count + 1);
                isVisited[i] = false;
            }
        }
        answer = Math.max(answer, count);
    }
}
