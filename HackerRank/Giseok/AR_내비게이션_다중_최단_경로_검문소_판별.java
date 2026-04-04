package HackerRank.Giseok;

import java.util.*;
import java.io.*;

public class AR_내비게이션_다중_최단_경로_검문소_판별 {

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

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Map<Integer, List<Node>> g = new HashMap<>();
        Map<Integer, List<Node>> rg = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g.computeIfAbsent(v1, k -> new ArrayList<>()).add(new Node(v2, w));
            rg.computeIfAbsent(v2, k -> new ArrayList<>()).add(new Node(v1, w));
        }

        int[] d = dik(n, s, g);
        int[] r = dik(n, e, rg);

        System.out.println(d[e]);

        int p = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean done = false;
        for (int i = 0; i < p; i++) {
            int gum = Integer.parseInt(st.nextToken());

            if (d[gum] + r[gum] == d[e]) {
                done = true;
                break;
            }
        }

        if (done)
            System.out.println("YES");
        else {
            System.out.println("NO");
        }
    }

    public static int[] dik(int n, int s, Map<Integer, List<Node>> g) {
        int[] d = new int[n + 1];
        Arrays.fill(d, 987654321);

        d[s] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        q.add(new Node(s, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            List<Node> nexts = g.get(node.v);
            if (nexts == null) {
                continue;
            }
            if (d[node.v] < node.val) {
                continue;
            }
            for (int i = 0; i < nexts.size(); i++) {
                Node next = nexts.get(i);

                if (next.val + node.val < d[next.v]) {
                    d[next.v] = next.val + node.val;
                    q.add(new Node(next.v, d[next.v]));
                }
            }
        }

        return d;
    }
}
