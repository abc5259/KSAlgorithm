package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static int K, C, R, res;
    static int[][] map;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C][K + 1];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(-1);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[] ky = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] kx = {-1, 1, 2, -2, 2, -2, 1, -1};

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, K});
        visit[0][0][K] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] arr = queue.poll();
                int y = arr[0];
                int x = arr[1];
                int remain = arr[2];

                if (y == R - 1 && x == C - 1) {
                    System.out.println(res);
                    System.exit(0);
                }
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < R && nx < C && !visit[ny][nx][remain] && map[ny][nx] == 0) {
                        visit[ny][nx][remain] = true;
                        queue.offer(new int[]{ny, nx, remain});
                    }
                }

                if (remain > 0) {
                    for (int i = 0; i < 8; i++) {
                        int ny = y + ky[i];
                        int nx = x + kx[i];

                        if (ny >= 0 && nx >= 0 && ny < R && nx < C && !visit[ny][nx][remain - 1] && map[ny][nx] == 0) {
                            visit[ny][nx][remain - 1] = true;
                            queue.offer(new int[]{ny, nx, remain - 1});
                        }
                    }
                }
            }
            res++;
        }
    }
}
// G3 말이 되고픈 원숭이
// trouble shooting
// K 값에 대해서
// K를 소모시키는 방법에 대해
// visit 방문 확인할 때 K값에 대해서 함께 확인
// K가 남아있으면 K가 가능한 경우의수를 같이 bfs에서 관리해야하므로 K를 감소시킨 값을 같이 queue에넣고 그때 좌표가 일치하면 최소값의 bfs를
// 반환할 수 있다.

