package Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이진트리순회
// 골드 5
public class BJ_5639 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        // 전위 순회한 값을 트리 구조로 만들기
        while (true) {
            String num = br.readLine();
            if (num == null || num.isEmpty()) break;
            root.insert(Integer.parseInt(num));
        }

        postOrder(root);

    }

    // 후위 순회
    public static void postOrder(Node node) {

        // 왼쪽, 오른쪽, 루트 순으로 조회
        if (node.left != null) {
            postOrder(node.left);
        }
        if (node.right != null) {
            postOrder(node.right);
        }
        System.out.println(node.num);

    }

    // 노드 클래스
    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }

        void insert(int num) {
            // 숫자가 더 크면 오른쪽
            if (num > this.num) {

                // 노드가 비어있으면 넣기
                if (this.right == null) {
                    this.right = new Node(num);
                    // 있으면 insert 함수 또 호출해서 비교해서 자식이 없는 노드를 찾아 넣기
                } else {
                    this.right.insert(num);
                }
                // 숫자가 작으면 왼쪽
            } else {
                // 노드가 비어있으면 넣기
                if (this.left == null) {
                    this.left = new Node(num);
                    // 있으면 insert 호출해서 비교 후 자식이 없는 노드에 넣기
                } else {
                    this.left.insert(num);
                }
            }
        }
    }
}

