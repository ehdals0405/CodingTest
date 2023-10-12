package Algorithm.Hash;

import java.util.*;

public class PG_베스트앨범 {

    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] genres, int[] plays) {

        // 장르별 플레이 횟수
        Map<String, Integer> play = new HashMap<>();
        // 장르별 고유 번호와 플레이 횟수
        Map<String, HashMap<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            if (!play.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                play.put(genres[i], plays[i]);
                music.put(genres[i], map);
            } else {
                play.put(genres[i], play.get(genres[i]) + plays[i]);
                music.get(genres[i]).put(i, plays[i]);
            }
        }
        // 플레이가 가장 많은 장르 순 정렬
        List<String> sortedGenre = new ArrayList<>(play.keySet());
        Collections.sort(sortedGenre, (o1, o2) -> play.get(o2) - play.get(o1));

        List<Integer> answer = new ArrayList<>();
        // 장르 내 가장 많이 재생된 순으로 정렬
        for (String genre : sortedGenre) {

            Map<Integer, Integer> map = music.get(genre);
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));

            // 2개까지만 선택
            answer.add(list.get(0));
            if (list.size() > 1) answer.add(list.get(1));
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }
}
