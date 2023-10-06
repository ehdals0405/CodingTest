package BaekJun.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17298 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // 숫자들 배열
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 인덱스 값을 저장할 스택
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            // 스택이 비어있지 않고 이전 인덱스와 현재 인덱스를 비교하여 숫자가 더 크면 해당 숫자로 변경 작으면 건너뜀
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i] ){
                nums[stack.pop()] = nums[i];
            }

            stack.push(i);
        }

        // 스택에 남아있는 인덱스들은 오큰수가 없으므로 -1로 바꿔줌
        while (!stack.isEmpty()){
            nums[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            sb.append(nums[i]).append(" ");
        }
        System.out.println(sb);
    }
}