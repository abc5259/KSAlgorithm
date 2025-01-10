package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1507 {
    static int N;
    static int[][] answer;
    static boolean[][] used;
    static int[][] dist;
    public static final int MAX = 2150 * 60;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new int[N+1][N+1];
        dist = new int[N+1][N+1];
        used = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                answer[i][j] = Integer.parseInt(st.nextToken());
                if(i != j) {
                    dist[i][j] = MAX;
                }
            }
        }

        int sum = 0;
        for(int j=1; j<=N; j++) {
            int min = Integer.MAX_VALUE;
            for(int i=1; i<=N; i++) {
                if (j == i) continue;
                min = Math.min(min, answer[i][j]);
            }

            for(int i=1; i<=N; i++) {
                if(answer[i][j] == min && dist[i][j] == MAX) {
                    dist[i][j] = min;
                    dist[j][i] = min;
                    sum+=min;
                }
            }
        }

        solve();
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        for(int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if(answer[i][j] < dist[i][j] && !used[i][j]) {
                    used[i][j] = true;
                    used[j][i] = true;
                    pq.offer(new Edge(i, j, answer[i][j]));
                }
                else if(answer[i][j] > dist[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if(pq.isEmpty()) {
            System.out.println(sum);
            return;
        }

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            if(dist[poll.v1][poll.v2] == poll.w) continue;
            if(dist[poll.v1][poll.v2] < poll.w) {
                System.out.println(-1);
                return;
            }
            dist[poll.v1][poll.v2] = poll.w;
            dist[poll.v2][poll.v1] = poll.w;
            sum += poll.w;
            solve();
        }

        System.out.println(sum);
    }

    static class Edge {
        int v1,v2,w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    public static void solve() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
