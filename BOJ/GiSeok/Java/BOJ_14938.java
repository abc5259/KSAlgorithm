package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14938 {

    static class Node {
        int v, val;

        public Node(int v, int val) {
            this.v = v;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) items[i] = Integer.parseInt(st.nextToken());

        List<List<Node>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());

            g.get(a).add(new Node(b, l));
            g.get(b).add(new Node(a, l));
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] v = new int[n];
            Arrays.fill(v, 987654321);

            PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
            q.add(new Node(i, 0));
            v[i] = 0;

            while (!q.isEmpty()) {
                Node node = q.poll();

                if (node.val > v[node.v]) continue;
                List<Node> nexts = g.get(node.v);
                for (int j = 0; j < nexts.size(); j++) {
                    Node next = nexts.get(j);
                    if (node.val + next.val < v[next.v]) {
                        v[next.v] = node.val + next.val;
                        q.add(new Node(next.v, v[next.v]));
                    }
                }
            }

            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (v[j] <= m) sum += items[j];
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
