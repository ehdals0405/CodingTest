package Algorithm.Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG_가장큰수 {

    public static void main(String[] args) {
//        PG_가장큰수 pg_가장큰수 = new PG_가장큰수();
//        System.out.println(pg_가장큰수.solution(new int[]{3, 30, 34, 5, 9}));

        int result = "303".compareTo("330");
        System.out.println(result);
    }

    public String solution(int[] numbers) {

        // 앞자리수가 큰 숫자가 가장 앞에 오도록
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
