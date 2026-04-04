package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_1504 {

    // 두 가지 조건을 만족해야 함
    // 1. 임의로 주어진 두 정점은 반드시 통과
    // 2. 이동했던 정점 + 간선도 다시 이동 가능
    //    -> 이런 경우 최단 경로가 되는게 존재하나?
    //    -> 두 정점을 지나는 경로에서 최단 경로는 존재할 수 있음
    // 임의의 두 노드에 대해서 다익스트라 한 다음
    // 1 -> 2 -> 3 -> 4
    // 1 -> 3 -> 2 -> 4
    // 중 최소만 구하면 됨

    static Map<Integer, List<Node>> g = new HashMap<>();
    static int n;

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
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g.computeIfAbsent(a, k -> new ArrayList<>()).add(new Node(b, c));
            g.computeIfAbsent(b, k -> new ArrayList<>()).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] d1 = dik(1);
        int[] d2 = dik(v1);
        int[] d3 = dik(v2);

        int ans = Math.min(d1[v1] + d2[v2] + d3[n], d1[v2] + d3[v1] + d2[n]);
        if (ans < 0 || ans >= 987654321) System.out.println(-1);
        else System.out.println(ans);
    }

    static int[] dik(int s) {
        int[] v = new int[n+1];
        Arrays.fill(v, 987654321);
        v[s] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        q.add(new Node(s, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (!g.containsKey(node.v)) continue;
            if (node.val > v[node.v]) continue;

            List<Node> nexts = g.get(node.v);
            for (int i = 0; i < nexts.size(); i++) {
                Node next = nexts.get(i);

                if (next.val + node.val < v[next.v]) {
                    v[next.v] = next.val + node.val;
                    q.add(new Node(next.v, v[next.v]));
                }
            }
        }

        return v;
    }
}
