package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PG_모음사전 {
    static List<String> words = new ArrayList<>();

    static String[] array = new String[]{"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        PG_모음사전 pg_모음사전 = new PG_모음사전();
        System.out.println(pg_모음사전.solution("AAAAE"));

        System.out.println(words.toString());
    }

    public int solution(String word) {

        // 중복 순열?

        for (int i = 0; i < 5; i++) {
            dfs(i + 1, "", 0);
        }

        Collections.sort(words);

        int answer = 0;
        for (String s : words) {
            answer++;
            if (s.equals(word)) break;
        }

        return answer;
    }

    public void dfs(int depth, String temp, int cnt) {

        if (depth == temp.length()) {
            words.add(temp);
            return;
        }

        for (int i = 0; i < 5; i++) {
            temp += array[i];
            dfs(depth, temp, cnt + 1);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
