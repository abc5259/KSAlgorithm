package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static ArrayList<Integer>[] net;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        net = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            net[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            net[from].add(to);
            net[to].add(from);
        }
        visit = new boolean[V + 1];

        int res = bfs(1);
        System.out.println(res - 1);
    }

    static int bfs(int v) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visit[v] = true;
        queue.offer(v);

        int cnt = 0;

        while (!queue.isEmpty()) {
            int vs = queue.poll();
            cnt++;
            for (Integer i : net[vs]) {
                if (!visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
        return cnt;
    }
}
// S3 바이러스 BFS
// 너무 쉽게 풀었다 int 로 반환