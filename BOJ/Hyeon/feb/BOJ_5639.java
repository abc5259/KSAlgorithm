package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }

        void insert(int num) {
            if (num < this.num) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) {
                break;
            }
            int num = Integer.parseInt(s);
            root.insert(num);
        }
        postOrder(root);
        System.out.println(sb);
    }

    public static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.num).append("\n");
    }
}


// G4 이진 검색 트리 binary search tree
// 일단 개 어렵게 풀었는데
// 먼저 순횐는 이해했으니 노드만 이해하면된다.
// 트리는 노드로 구성되어있고 루트노드와 자식노드로 구성되어있다. 먼저 노드에 루트노드를 생성하고 노드에 넣는 insert메소드를 만든다.
// 루트 노드 생성시에는 num 값에 노드값이 들어있고 left right는 공석이라 null이다.
// 이때 30이 들어왔으면 30은 num의 50보다 작고 left가 null이여서 this.left의 root값이 된다.
// 만약 left가 존재하면 그 밑의 left에 넣는다. right 도 마찬가지이다.

// 순회는 후위 순회여서 출력하고 왼쪽 오른쪽 탐색하면된다.