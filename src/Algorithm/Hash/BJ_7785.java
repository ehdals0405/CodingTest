package Algorithm.Hash;

import java.util.*;

public class BJ_7785 {

    public static void main(String[] args) {

        // 출입 기록수 n
        // n개의 줄에는 이름과 enter 또는 leave

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        HashMap<String, String> commute = new HashMap<>();

        // 이름과 출퇴근 상태를 map에 넣기
        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] commuteStatus = line.split(" ");
            commute.put(commuteStatus[0], commuteStatus[1]);

        }

        List<String> employees = new ArrayList<>();

        // Map에서 value가 enter 인 key 값만 출력
        for (Map.Entry<String, String> entry : commute.entrySet()) {
            if ("enter".equals(entry.getValue())) {
                employees.add(entry.getKey());
            }
        }
        // 이름 역순으로 정렬
        employees.sort(Comparator.reverseOrder());

        for (String employee : employees) {
            System.out.println(employee);
        }
    }
}
