package Algorithm.Programmers;

import java.util.HashMap;
import java.util.Map;

public class PG_추억점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 맵에 이름과 그리움 점수를 넣고 배열을 순회하면서 점수 더하기

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] scores = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int score = 0;

            for (int j = 0; j < photo[i].length; j++) {

                String yearnName = photo[i][j];

                if (map.containsKey(yearnName)){
                    score += map.get(yearnName);
                }
            }
            scores[i] = score;
        }
        return scores;
    }

}
