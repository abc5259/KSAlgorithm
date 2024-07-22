package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1507 {
    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static int[] cost;
    static int[] indegree;
    static List<List<Node>> graph;
    static Queue<Node> q = new LinkedList<>();
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        cost = new int[N+1];
        time = new int[N+1];
        indegree = new int[N+1];
        Arrays.fill(cost, 0);
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());


        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            indegree[i] = Integer.parseInt(st.nextToken());
            if(indegree[i] == 0) {
                q.offer(new Node(i,t));
                cost[i] = t;
            }
            for(int j=1; j<=indegree[i]; j++) {
                int v1 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(new Node(i, t));
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {

        int max = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            max = Math.max(max, cur.w);
            for(Node next: graph.get(cur.v)) {
                if(cost[next.v] < cur.w + next.w) {
                    cost[next.v] = cur.w + next.w;
                }
                indegree[next.v]--;
                if(indegree[next.v] == 0) {
                    q.offer(new Node(next.v, cost[next.v]));
                }
            };
        }

        return max;
    }
}
