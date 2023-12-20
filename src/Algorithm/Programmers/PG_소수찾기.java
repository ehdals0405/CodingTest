package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PG_소수찾기 {

    public static void main(String[] args) {

        PG_소수찾기 pg_소수찾기 = new PG_소수찾기();

        System.out.println(pg_소수찾기.solution("011"));
    }

    static List<Integer> arr = new ArrayList<>();
    static boolean[] visited = new boolean[7];

    public int solution(String numbers) {

        int answer = 0;

        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numbers, "", i);
        }

        for (int num : arr) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    private void dfs(String str, String temp, int cnt) {
        // 재귀 종료 조건
        if (temp.length() == cnt) {
            int num = Integer.parseInt(temp);
            if (!arr.contains(num)) {
                arr.add(num);
                return;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp += str.charAt(i);
                dfs(str, temp, cnt);
                visited[i] = false;
                temp = temp.substring(0, temp.length() - 1);

            }
        }
    }

    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
