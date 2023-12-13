package Algorithm.Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PCCP1 {
    public static void main(String[] args) {

        int[][] array = new int[][]{{2,10},{9,15},{10,5},{11,5}};
        int result = solution(new int[]{5,1,5}, 30, array);

        System.out.println(result);
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {

        Queue<int[]> attackQueue = new LinkedList();
        int battleTime = 1;
        int bandageTime = 0;
        int currentHealth = health;

        // 공격 배열 큐에 넣기
        for (int i = 0; i < attacks.length; i++) {
            attackQueue.add(attacks[i]);
        }

        // 공격이 끝날 떄 까지 반복
        while (!attackQueue.isEmpty()) {


            int[] attack = attackQueue.peek();
            int attackSecond = attack[0];

            // 전투 시간과 공격 시간을 비교 후 같으면 공격
            if (attackSecond == battleTime) {
                // 큐에서 꺼내서 공격
                attackQueue.poll();
                currentHealth -= attack[1];
                bandageTime = 0;

                // 체력이 0 이하면 -1
                if (currentHealth <= 0) {
                    return -1;
                }

            } else {

                // 공격 받지 않으면 붕대 시간 1 추가
                bandageTime++;
                // 회복
                currentHealth += bandage[1];
                // 시전 시간이 충족되면 추가 회복
                if (bandageTime == bandage[0]) {
                    currentHealth += bandage[2];
                    // 최대치면 다시 리셋
                    bandageTime = 0;
                }
                // 최대 체력 이상으로 회복했으면 최대 체력으로 고정
                if (currentHealth > health) {
                    currentHealth = health;
                }
            }

            // 전투 시간 증가
            battleTime++;

        }
        return currentHealth;
    }
}
