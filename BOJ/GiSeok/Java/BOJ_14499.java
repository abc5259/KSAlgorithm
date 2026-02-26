package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {

    // 1:32:31

    static int[] dy = {0, 0, 0, -1, 1};
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dice = {0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int jy = Integer.parseInt(st.nextToken());
        int jx = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(st.nextToken());

            int ny = jy + dy[input];
            int nx = jx + dx[input];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

            // 0 상 1 하 2 동 3 서 4 남 5 북
            if (input == 1) {
                int tmp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = tmp;
            } else if (input == 2) {
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = tmp;
            } else if (input == 3) {
                int tmp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[0];
                dice[0] = dice[4];
                dice[4] = tmp;
            } else {
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[5];
                dice[5] = tmp;
            }

            if (map[ny][nx] == 0) {
                map[ny][nx] = dice[1];
            } else {
                dice[1] = map[ny][nx];
                map[ny][nx] = 0;
            }

            System.out.println(dice[0]);
            jy = ny;
            jx = nx;
        }
    }
}
