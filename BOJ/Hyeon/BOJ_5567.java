package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5567 {
    static ArrayList<Integer>[] adj;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];

        cnt = new int[n + 1];
        Arrays.fill(cnt, -1);

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        bfs();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] != -1) {
                res += cnt[i];
            }
        }
        System.out.print(res);
    }

    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        cnt[1] = 0;

        for (int friends : adj[1]) {
            queue.offer(friends);
            cnt[friends] = 0;
            cnt[1]++;
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int friends : adj[poll]) {
                if (cnt[friends] == -1) {
                    cnt[friends] = 0;
                    cnt[poll]++;
                }
            }
        }
    }
}
// S2 결혼식 BFS
// 20분
// 생각하는게 좀 걸렸는데 결론 적으로는 친구 와 친구의 친구까지 만 초대한다고 생각하는 매커니즘