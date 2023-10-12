package Algorithm.Hash;

import java.util.*;

public class BJ_16165 {

    public static void main(String[] args) {

        // 걸그릅수 N 맞혀야 할 문제 수 M

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int M = sc.nextInt();
        sc.nextLine();

        // 팀이름, 멤버들 Map 생성
        HashMap<String, String> girlGroup = new HashMap<>();

        while (N-- > 0) {
            // 그룹 이름
            String groupName = sc.nextLine();
            // 그룹 멤버 수
            int groupNum = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < groupNum; i++) {
                // 멤버 이름을 키, 그룹 이름을 벨류로 넣기
                String memberName = sc.nextLine();
                girlGroup.put(memberName, groupName);
            }
        }

        while (M-- > 0) {

            // 문제
            String question = sc.nextLine();
            // 문제 유형
            int questionType = sc.nextInt();
            sc.nextLine();

            // 문제 유형이 1 이면 멤버 이름으로 그룹이름 출력
            if (questionType == 1) {

                String groupName = girlGroup.get(question);
                System.out.println(groupName);
            }
            // 문제 유형이 0 이면 그룹이름으로 모든 멤버 이름 출력
            else {

                List<String> groupMember = new ArrayList<>();

                for (Map.Entry<String, String> members : girlGroup.entrySet()) {

                    if (members.getValue().equals(question)) {
                        groupMember.add(members.getKey());
                    }
                }
                // 사전 순으로 정렬
                groupMember.sort(Comparator.naturalOrder());

                for (String name : groupMember) {

                    System.out.println(name);
                }
            }

        }
    }
}
