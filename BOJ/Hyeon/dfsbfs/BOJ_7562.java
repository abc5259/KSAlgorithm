package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            len = Integer.parseInt(br.readLine());
            visit = new boolean[len][len];
            chess = new int[len][len];

            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            tx = Integer.parseInt(st.nextToken());
            ty = Integer.parseInt(st.nextToken());
            cnt = 0;
            System.out.println(dfs(fy, fx));
        }
    }

    static int[] dy = {2, -2, 1, -1};
    static int[] dx = {1, -1, 1, -1, 2, -2, 2, -2};
    static int cnt, len;
    static int tx, ty;
    static boolean[][] visit;
    static int[][] chess;

    static int dfs(int y, int x) {
        if (tx == x && ty == y) {
            return cnt;
        }
        chess[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i / 2];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < len && nx < len && chess[ny][nx]) {
                chess[ny][nx] = true;

                dfs(ny, nx);
                chess[ny][nx] = false;
            }
        }
        return cnt;
    }
}
