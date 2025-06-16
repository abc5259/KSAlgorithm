package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583 {
    static int M, N, K;
    static boolean[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        square = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int row = y1; row < y2; row++) {
                for (int col = x1; col < x2; col++) {
                    square[row][col] = true;
                }
            }
        }
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!square[i][j]) {
                    pq.offer(bfs(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        square[y][x] = true;

        int size = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= M || nx >= N || square[ny][nx]) {
                    continue;
                }
                queue.offer(new int[]{ny, nx});
                square[ny][nx] = true;
                size++;
            }
        }
        return size;
    }
}
