package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

// 1. 35%에서 틀림: -1 출력 안해서 그런거였음
public class BOJ_18352 {

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
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;

        Map<Integer, List<Integer>> gh = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            List<Integer> list;
            if (gh.containsKey(a)) {
                list = gh.get(a);
            } else {
                list = new ArrayList<>();
            }
            list.add(b);
            gh.put(a, list);
        }

        int[] v = new int[n];
        Arrays.fill(v, 987654321);

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        q.add(new Node(x, 0));
        v[x] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (!gh.containsKey(node.v)) continue;

            if (v[node.v] < node.val) continue;
            List<Integer> nexts = gh.get(node.v);
            for (int i = 0; i < nexts.size(); i++) {
                int next = nexts.get(i);

                if (v[next] > node.val + 1) {
                    v[next] = node.val + 1;
                    q.add(new Node(next, v[next]));
                }
            }
        }

        boolean done = false;
        for (int i = 0; i < n; i++) {
            if (v[i] == k) {
                System.out.println(i+1);
                done = true;
            }
        }

        if (!done) {
            System.out.println(-1);
        }
    }
}
