package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static int n, x, y;
    static int[] arr;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        graph = new int[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        bfs(x);
        if (arr[y] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(arr[y]);
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int nx = queue.poll();

            for (int i = 0; i <= n; i++) {
                if (graph[nx][i] == 1 && arr[i] == 0) {
                    queue.offer(i);
                    arr[i] = arr[nx] + 1;
                }
            }
        }
    }
}

// S2 촌수계산 BFS
// retry