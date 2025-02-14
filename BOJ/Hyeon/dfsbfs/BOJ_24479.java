package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24479 {
    static int N, M;
    static ArrayList<Integer>[] adjlist;
    static int[] visit;

    static StringBuilder sb = new StringBuilder();

    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjlist = new ArrayList[N + 1];
        visit = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adjlist[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjlist[u].add(v);
            adjlist[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(adjlist[i]);
        }

        dfs(R);
        for (int i = 1; i <= N; i++) {
            sb.append(visit[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int sv) {
        visit[sv] = cnt;

        List<Integer> list = adjlist[sv];
        for (Integer i : list) {
            if (visit[i] == 0) {
                cnt++;
                dfs(i);
            }
        }
    }
}
