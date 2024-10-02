package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_24042 {
    static class Load {
        int v;
        long t;

        public Load(int v, long t) {
            this.v = v;
            this.t = t;
        }
    }
    static int N,M;
    static List<List<Load>> graph = new ArrayList<>();
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Load(e, i));
            graph.get(e).add(new Load(s, i));
        }

        solve();
        System.out.println(dist[N]);
    }

    static void solve() {
        PriorityQueue<Load> pq = new PriorityQueue<>((a,b) -> Long.compare(a.t, b.t));
        dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new Load(1, 0));

        while (!pq.isEmpty()) {
            Load load = pq.poll();

            if(dist[load.v] < load.t) continue;

            for(Load next: graph.get(load.v)) {
                long currTime = load.t;
                long currM = load.t / M;
                long nextTime = currM * M + next.t + 1;
                if(nextTime < currTime) {
                    nextTime += M;
                }
                if(dist[next.v] < nextTime) continue;
                pq.offer(new Load(next.v, nextTime));
                dist[next.v] = nextTime;
            }
        }

    }
}
