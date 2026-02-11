package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] tree = new Node[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new Node(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int parentIdx = -1;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                parentIdx = i;
            } else {
                tree[parent].children.add(tree[i]);
            }
        }

        removeIdx = Integer.parseInt(br.readLine());

        if (removeIdx == parentIdx) {
            System.out.println(0);
            return;
        }

        dfs(tree[parentIdx]);

        System.out.println(cnt);
    }

    static int removeIdx;
    static int cnt;

    static void dfs(Node node) {
        if (node.idx == removeIdx) {
            return;
        }

        boolean hasChild = false;

        for (Node next : node.children) {
            if (next.idx != removeIdx) {
                hasChild = true;
                dfs(next);
            }
        }

        if (!hasChild) {
            cnt++;
        }
    }

    static class Node {
        int idx;
        List<Node> children;

        public Node(int idx) {
            this.idx = idx;
            children = new ArrayList<>();
        }
    }
}
// G5 트리 트리, DFS 재귀 복습 필
// 1시간 12
// 바이너리 트리인줄
// 걍 기초 부족
// 엣지케이스 못찾음 다시 해야됨