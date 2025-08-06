package BOJ.GiSeok.Java.retry.reretry;

// 00:14:57 G4
import java.util.*;
import java.io.*;

public class BOJ_14502 {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int n, m;
    private static int[][] 연구실;
    private static boolean[][] visited;
    private static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        연구실 = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) 연구실[y][x] = Integer.parseInt(st.nextToken());
        }

        벽세우기(0, 0, 0);

        System.out.println(ret);
    }

    private static void 벽세우기(int y, int x, int wall) {
        if (wall == 3) {
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (연구실[i][j] == 2 && !visited[i][j]) {
                        퍼뜨리기(i, j);
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (연구실[i][j] == 0 && !visited[i][j]) cnt++;
                }
            }

            ret = Math.max(ret, cnt);
            return;
        }

        for (int i = y; i < n; i++) {
            for (int j = y != i ? 0 : x; j < m; j++) {
                if (연구실[i][j] == 0) {
                    연구실[i][j] = 1;
                    벽세우기(i, j, wall+1);
                    연구실[i][j] = 0;
                }
            }
        }
    }

    private static void 퍼뜨리기(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (연구실[ny][nx] == 1) continue;

            퍼뜨리기(ny, nx);
        }
    }
}
