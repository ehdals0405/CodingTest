package Algorithm.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_26043 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 좋아하는 메뉴 먹은 학생 목록
        ArrayList<Integer> A = new ArrayList<>();
        // 식사만 한 학생 목록
        ArrayList<Integer> B = new ArrayList<>();
        // 못먹은 학생 목록
        ArrayList<Integer> C = new ArrayList<>();

        Queue<Student> students = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        // 반복 횟수
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");
            // 유형 1 또는 2 확인
            int type = Integer.parseInt(st.nextToken());
            // 1 유형은 학생이므로 학생 정보를 넣고 queue에 넣어줌
            if (type == 1) {
                int num = Integer.parseInt(st.nextToken());
                int favorite = Integer.parseInt(st.nextToken());
                students.add(new Student(num, favorite));
            } else {
                // 2 유형은 메뉴 정보를 queue에 넣어줌
                int menu = Integer.parseInt(st.nextToken());
                Student student = students.poll();
                if (student.favorite == menu) {

                    A.add(student.num);
                } else B.add(student.num);

            }
        }
        // 남은 학생들은 C 목록에 넣어줌
        while (!students.isEmpty()) {
            C.add(students.poll().num);
        }

        // 출력
        print(A);
        print(B);
        print(C);


    }

    static void print(List<Integer> list) {

        if (list.isEmpty()) {
            System.out.println("None");
        } else {
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i + " ");
            }
            System.out.println(sb);
        }
    }

    // 학생 정보
    static class Student {

        Student(int num, int favorite) {
            this.num = num;
            this.favorite = favorite;
        }

        int num;
        int favorite;
    }
}

