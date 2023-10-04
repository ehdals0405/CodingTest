package BaekJun.Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        Stack<Top> stack = new Stack();

        // 탑의 수 N
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int topNum = 1;

        while (N-- > 0) {

            // 탑 높이
            int height = Integer.parseInt(st.nextToken());

            // 스택이 비어있거나 수신할 탑이 없으면 0 출력하고 새로운 탑 넣기
            if (stack.isEmpty()) {
                result.append("0 ");
                stack.push(new Top(topNum, height));

            } else
                while (true) {

                    if (stack.isEmpty()) {
                        result.append("0 ");
                        stack.push(new Top(topNum, height));
                        break;
                    }

                    Top top = stack.peek();
                    // 스택에 있는 탑 높이와 수신 보낸 탑 높이를 비교
                    if (top.height >= height) {
                        // 탑 높이가 더 크면 탑 번호 출력 후 스택에 넣기
                        result.append(top.num + " ");
                        stack.push(new Top(topNum, height));
                        break;
                        // 탑 높이가 더 작으면 스택에서 빼기
                    } else stack.pop();
                    // 스택이 비거나 수신을 받을 수 있을 때 까지 반복
                }
            topNum++;
        }
        bw.write(result.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static class Top {
        // 탑 번호와 높이 정보
        Top(int num, int height) {
            this.num = num;
            this.height = height;
        }

        int num;
        int height;
    }
}
