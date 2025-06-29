package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16940 {
    static int N, idx;
    static int[] ans;
    static boolean[] visit;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ans = new int[N + 1];
        visit = new boolean[N + 1];

        adjList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            adjList[b].add(a);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        sb.append(!bfs() || ans[0] != 1 ? 0 : 1);
        System.out.println(sb);
    }

    static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        int tmp = 1;
        visit[tmp] = true;
        queue.offer(tmp);
        idx = 1;

        while (!queue.isEmpty()) {
            tmp = queue.poll();

            int cnt = 0;

            for (int to : adjList[tmp]) {
                if (!visit[to]) {
                    visit[to] = true;
                    cnt++;
                }
            }

            for (int j = idx; j < idx + cnt; j++) {

                if (!visit[ans[j]]) {
                    return false;
                } else {
                    queue.offer(ans[j]);
                }
            }
            idx += cnt;
        }
        return true;
    }
}

// G5 스페셜 저지 BFS
// 일단 풀었다. 간선 리스트