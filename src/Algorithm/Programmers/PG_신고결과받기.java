package Algorithm.Programmers;

import java.util.*;

public class PG_신고결과받기 {

    public static void main(String[] args) {

        PG_신고결과받기 pg_신고결과받기 = new PG_신고결과받기();
        int[] solution = pg_신고결과받기.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(String[] id_list, String[] report, int k) {

        // 맵에 신고자와 신고받은 사람을 저장
        // 신고 받은 사람이 k 이상이면 메일 보내기

        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();

        //id_list의 이름을 name 변수에 저장하여 map과 idxMap에 저장
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            idxMap.put(name, i);
        }

        //report 배열의 인덱스를 split으로 쪼개고, map의 신고당한 유저(to)에 선언된
        //Set에 신고한 유저(from) 추가
        for (String s : report) {
            String[] str = s.split(" ");	//"muzi frodo"
            String from = str[0];			//str[0] = "muzi"
            String to = str[1];				//str[1] = "frodo"
            map.get(to).add(from);
        }

        //map에서 id_list 배열의 값을 키로 하여 값을 가져와
        //send Set에 담아주고, 2회 이상 등록된 유저의 인덱스를
        //idxMap에서 가져와 answer 배열의 값을 +!
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> send = map.get(id_list[i]);
            if (send.size() >= k) {
                for (String name : send) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
