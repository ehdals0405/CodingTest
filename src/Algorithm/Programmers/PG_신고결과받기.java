package Algorithm.Programmers;

import java.util.*;

public class PG_신고결과받기 {

    public static void main(String[] args) {

        PG_신고결과받기 pg_신고결과받기 = new PG_신고결과받기();
        int[] solution = pg_신고결과받기.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        // 맵에 신고받은 사람과 신고한 사람을 저장
        // 신고한 사람이 k 이상이면 신고한 사람에게 메일 보내기
        // 이름과 인덱스 값을 저장할 맵도 추가
        Map<String, HashSet<String>> reporting = new HashMap<>();
        Map<String, Integer> idx = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            idx.put(name, i);
            reporting.put(name, new HashSet<>());
        }

        for (String s : report) {
            String[] name = s.split(" ");
            String reporter = name[0];
            String reported = name[1];

            reporting.get(reported).add(reporter);
        }

        for (String name : reporting.keySet()) {
            Set<String> set = reporting.get(name);
            if (set.size() >= k) {
                for (String s : set) {
                    answer[idx.get(s)]++;
                }
            }
        }
        return answer;
    }
}
