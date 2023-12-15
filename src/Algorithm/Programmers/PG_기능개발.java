package Algorithm.Programmers;

import java.util.*;

public class PG_기능개발 {

    public static void main(String[] args) {

        PG_기능개발 pg_기능개발 = new PG_기능개발();
        int[] arr = pg_기능개발.solution(new int[]{93,30,55}, new int[]{1,30,5});
        System.out.println(Arrays.toString(arr));
    }

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> works = new LinkedList<>();
        List<Integer> developCount = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {

            int day = 100 - progresses[i];

            if (day % speeds[i] == 0) works.offer(day / speeds[i]);
            else works.offer(day / speeds[i] + 1);

        }

        int count = 1;
        int current = works.poll();

        while (!works.isEmpty()) {

            if(current >= works.peek()){
                count++;
                works.poll();
            } else {
                developCount.add(count);
                count = 1;
                current = works.poll();
            }
        }
        developCount.add(count);

        int[] answer = developCount.stream().mapToInt(i->i).toArray();

        return answer;
    }

}
