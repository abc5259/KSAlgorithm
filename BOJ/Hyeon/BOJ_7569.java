package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int[][][] tomatoes;
    static int M, N, H;
    static ArrayDeque<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();
        tomatoes = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        bfs();

        int cnt = -1;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] > cnt) {
                        cnt = tomatoes[i][j][k];
                    }
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(cnt - 1);
    }

    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {0, 0, 0, 0, 1, -1};

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int z = arr[0];
            int y = arr[1];
            int x = arr[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nz >= 0 && ny >= 0 && nx >= 0 && nx < M && ny < N && nz < H && tomatoes[nz][ny][nx] == 0) {
                    tomatoes[nz][ny][nx] = tomatoes[z][y][x] + 1;
                    queue.offer(new int[]{nz, ny, nx});
                }
            }
        }
    }
}

// G5 토마토2 BFS
// 3차원 문제의 토마토
// 3차원을 어떻게 쓰냐? 면 - 행 - 열 로 사용하고
// 델타 또한 4가지에서 6방향으로 확장되었다
// 그리고 나머지는 +1씩 누적합으로 지나간 날을 확인할 수 있고세부조건으로 판별 가능하다.