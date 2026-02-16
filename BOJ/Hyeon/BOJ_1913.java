package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int r = 0, c = 0, value = N * N;

        map[r][c] = value;

        int ty = 1, tx = 1;
        if (value != num) {
            ty = 0;
            tx = 0;
        }

        int dir = 0;

        while (value > 1) {
            int ny = r + dy[dir];
            int nx = c + dx[dir];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                ny = r + dy[dir];
                nx = c + dx[dir];
            }

            r = ny;
            c = nx;
            value--;
            map[r][c] = value;

            if (value == num) {
                ty = r + 1;
                tx = c + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ty).append(" ").append(tx);

        System.out.println(sb);
    }
}
// S3 달팽이 구현
// 30분
// 아니 달팽이 문제를 까먹어서 mod 연산인거 알았는데