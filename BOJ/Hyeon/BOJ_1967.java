package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1967 {
    static int n;
    static List<Node>[] tree;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, w));
            tree[child].add(new Node(parent, w));
        }

        visit = new boolean[n + 1];


        dfs(1, 0);

        Arrays.fill(visit, false);
        max = 0;

        dfs(maxNode, 0);
        System.out.println(max);
    }

    static int maxNode;
    static int max;

    static void dfs(int num, int sum) {
        if (max < sum) {
            max = sum;
            maxNode = num;
        }
        visit[num] = true;

        for (Node next : tree[num]) {
            if (!visit[next.to]) {
                dfs(next.to, sum + next.w);
            }
        }
    }

    static class Node {
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}
// G4 트리의 지름 트리 DFS
// 50분
// 다시 풀기.