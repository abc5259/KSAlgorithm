package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405 {
    static int N, K;
    static int[][] virus;
    static boolean[][] visit;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        virus = new int[N][N];
        visit = new boolean[N][N];

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[3] == o2[3]) {
                    return o1[2] - o2[2];
                }
                return o1[3] - o2[3];
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                virus[i][j] = Integer.parseInt(st.nextToken());
                if (virus[i][j] != 0) {
                    visit[i][j] = true;
                    pq.offer(new int[]{i, j, virus[i][j], 0});
                    // y, x, 바이러스 종류, 시간
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());

        bfs(time);
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(virus[x][y]);
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static void bfs(int time) {

        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] poll = pq.poll();
                int y = poll[0];
                int x = poll[1];
                int p = poll[2];
                int s = poll[3];

                if (s == time) {
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) {
                        continue;
                    }
                    if (virus[ny][nx] == 0) {
                        visit[ny][nx] = true;
                        virus[ny][nx] = p;
                        pq.offer(new int[]{ny, nx, p, s + 1});
                    }
                }
            }
        }
    }
}

// G5 경쟁적 전염 BFS
// 풀었다.