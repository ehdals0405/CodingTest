package BaekJun.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_29813 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Student> queue = new LinkedList();

        int N = Integer.parseInt(br.readLine());

        // 학생 정보 입력
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            queue.add(new Student(s[0],Integer.parseInt(s[1])));
        }

        // 한명 남을 때 까지 반복
        while (queue.size() != 1){

            // 첫 학생
            Student first = queue.poll();
            // 학번 -1 만큼 뒤로 보내고 팀원으로 받기
            int count = first.num - 1;
            for (int i = 0; i < count; i++) {
                queue.add(queue.poll());
            }
            // 팀원으로 뽑기
            queue.poll();
        }
        // 마지막 남은 팀원 출력
        System.out.println(queue.peek().initial);



    }
    // 학생 정보
    static class Student{

        Student(String initial, int num) {
            this.initial = initial;
            this.num = num;
        }
        String initial;
        int num;
    }
}
