package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1389 {
    static int N;
    static ArrayList<Integer>[] adj;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            adj[B].add(A);
        }

        int res = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 1; i <= N; i++) {
            cnt = new int[N + 1];

            Arrays.fill(cnt, -1);

            int tmp = bfs(i);

            if (res > tmp) {
                res = tmp;
                idx = i;
            }
        }

        System.out.print(idx);
    }

    static int bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        cnt[start] = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int next : adj[poll]) {
                if (cnt[next] != -1) {
                    continue;
                }
                queue.offer(next);
                cnt[next] = cnt[poll] + 1;
            }
        }
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += cnt[i];
        }
        return sum;
    }
}
// S1 케빈 베이컨의 6단계 법칙 BFS
// 15분 만에 했음
// 각 방문여부를 cnt 로 잡고 bfs 돌릴 때마다 초기화