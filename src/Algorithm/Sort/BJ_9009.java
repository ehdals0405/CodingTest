package Algorithm.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9009 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {

            // 피보나치 수를 담을 배열
            ArrayList<Integer> fibonacci = new ArrayList<>();
            // 결과 배열을 담기
            ArrayList<Integer> result = new ArrayList<>();

            // 숫자보다 작은 피보나치 수 배열 생성
            int num = Integer.parseInt(br.readLine());
            fibonacci = fibonacci(fibonacci, num);

            // 피보나치 배열에서 하나씩 꺼내서 num 이 0이 될때까지 뺴줌
            for (int j = 0; j < fibonacci.size(); j++) {

                if (num == 0) break;

                else {
                    int fibonacciNum = fibonacci.get(j);

                    if (num - fibonacciNum >= 0) {
                        num -= fibonacciNum;
                        result.add(fibonacciNum);
                    }
                }

            }

            // 역순으로 출력
            Collections.sort(result);
            // 출력
            for (int j = 0; j < result.size(); j++) {
                sb.append(result.get(j) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 숫자보다 작은 피보나치 수 배열 만들기
    static ArrayList<Integer> fibonacci(ArrayList<Integer> fibonacci, int num) {

        int i = 2;
        fibonacci.add(0);
        fibonacci.add(1);

        while (true) {

            int nextFibonacci;
            nextFibonacci = fibonacci.get(i - 1) + fibonacci.get(i - 2);

            if (nextFibonacci > num) break;

            fibonacci.add(nextFibonacci);
            i++;
        }
        // 큰 숫자부터 꺼내기 위해 내림차순 정렬
        Collections.sort(fibonacci, Collections.reverseOrder());

        return fibonacci;
    }
}
