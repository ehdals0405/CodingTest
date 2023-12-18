package Algorithm.Programmers;

import java.util.Arrays;

public class PG_K번째수 {
    public static void main(String[] args) {

        PG_K번째수 p = new PG_K번째수();
        System.out.println(Arrays.toString(p.solution(new int[]{1,5,2,6,3,7,4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}})));
    }

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int start = commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];

            int[] arr = Arrays.copyOfRange(array, start-1, end);
            sort(arr,0,arr.length-1);
//            Arrays.sort(arr);
            answer[i] = arr[num-1];

        }
        return answer;
    }

    private void sort(int[] array, int start, int end) {

        int part = partition(array, start, end);

        if (start < part - 1) sort(array, start, part - 1);
        if (part < end) sort(array, part, end);

    }

    private int partition(int[] array, int start, int end) {

        int pivot = array[(start + end) / 2];

        while (start <= end) {

            while (array[start] < pivot) start++;
            while (array[end] > pivot) end--;

            if (start <= end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;

            }
        }
        return start;
    }
}
