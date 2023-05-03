package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1738 {
    static int N,M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] predecessor;
    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        dist = new int[N+1];
        predecessor = new int[N + 1];

        Arrays.fill(predecessor,-1);
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }

        if (dist[N] == Integer.MIN_VALUE) {
            System.out.println(-1);
            return;
        }

        for(int j=1; j<=N; j++) {

            for(Node next: graph.get(j)) {
                int from = j;
                int to = next.v;
                int weight = next.w;
                if (dist[from] == Integer.MIN_VALUE) {
                    continue;
                }

                if (isCycle(from, to, weight) && isCycleOnPath(to)) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = N;
        sb.append(N);
        while (predecessor[index] != -1) {
            sb.insert(0, predecessor[index] + " ");
            index = predecessor[index];
        }
        System.out.print(sb.toString());
    }
    public static boolean bellmanford() {
        Arrays.fill(dist,Integer.MIN_VALUE);
        dist[1] = 0;
        for(int i=1; i<=N-1; i++) {
            for(int j=1; j<=N; j++) {
                for(Node next: graph.get(j)) {
                    if(dist[j] != Integer.MIN_VALUE  && dist[next.v] < dist[j] + next.w) {
                        dist[next.v] = dist[j] + next.w;
                        predecessor[next.v] = j;
                    }
                }
            }
        }

        return true;
    }
    private static boolean isCycle(int from, int to, int weight) {
        return dist[to] < dist[from] + weight;
    }

    private static boolean isCycleOnPath(int targetVertex) {
        boolean[] visit = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(targetVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (visit[currentVertex]) {
                continue;
            }
            visit[currentVertex] = true;

            for(int j=1; j<=N; j++) {

                for(Node next: graph.get(j)) {
                    int from = j;
                    int to = next.v;
                    if (from == currentVertex && !visit[to]) {
                        queue.add(to);
                    }
                }
            }
        }

        return visit[N];
    }

}
