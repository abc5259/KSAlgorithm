package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {
    static int N, K;
    static int[] visited;
    static int MAX = 100_000;
    static Map<Integer, Integer> map = new HashMap<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[MAX+1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        dfs();

        System.out.println(min);
        System.out.println(map.get(min));
    }

    static void dfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});
        visited[N] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int nx = cur[0] - 1;
            if (nx >= 0 && nx <= MAX && visited[nx] >= cur[1] + 1) {
                if (cur[0] - 1 == K) {
                    min = Math.min(min, cur[1] + 1);
                    map.put(cur[1] + 1, map.getOrDefault(cur[1] + 1, 0) + 1);
                }else {
                    visited[nx] = cur[1] + 1;
                    q.offer(new int[]{nx, cur[1] + 1});
                }
            }

            nx = cur[0] + 1;
            if (nx >= 0 && nx <= MAX && visited[nx] >= cur[1] + 1) {
                if (cur[0] + 1 == K) {
                    min = Math.min(min, cur[1] + 1);
                    map.put(cur[1] + 1, map.getOrDefault(cur[1] + 1, 0) + 1);
                }else {
                    visited[nx] = cur[1] + 1;
                    q.offer(new int[]{nx, cur[1] + 1});
                }
            }

            nx = cur[0] * 2;
            if (nx >= 0 && nx <= MAX && visited[nx] >= cur[1] + 1) {
                if (cur[0] * 2 == K) {
                    min = Math.min(min, cur[1] + 1);
                    map.put(cur[1] + 1, map.getOrDefault(cur[1] + 1, 0) + 1);
                }else {
                    visited[nx] = cur[1] + 1;
                    q.offer(new int[]{nx, cur[1] + 1});
                }
            }
        }
    }
}
