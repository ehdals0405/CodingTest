package Algorithm.Programmers;

import java.util.*;

public class PG_같은숫자는싫어 {

    public static void main(String[] args) {

        int[] array = new int[]{1, 1, 3, 3, 0, 1, 1};
        PG_같은숫자는싫어 pg_같은숫자는싫어 = new PG_같은숫자는싫어();
        int[] a = pg_같은숫자는싫어.solution(array);

        System.out.println(Arrays.toString(a));
    }

    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int num = stack.peek();
            if (!(num == arr[i]))
                stack.add(arr[i]);
        }

        int[] answer = stack.stream().mapToInt(i -> i).toArray();


        return answer;
    }
}
