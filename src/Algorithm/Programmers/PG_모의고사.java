package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_모의고사 {

    public static void main(String[] args) {

        PG_모의고사 pg_모의고사 = new PG_모의고사();
        System.out.println(pg_모의고사.solution(new int[]{1,2,3,4,5}));
    }

    public int[] solution(int[] answers) {

        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] person = new int[3];

        for (int i = 0; i < answers.length; i++) {

            if (answers[i] == a[i % 5]) person[0]++;
            if (answers[i] == b[i % 8]) person[1]++;
            if (answers[i] == c[i % 10]) person[2]++;
        }

        int max = Math.max(person[0], Math.max(person[1], person[2]));
        // 가장 높은 점수 받은 사람 리스트
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            if (max == person[i]) list.add(i + 1);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
