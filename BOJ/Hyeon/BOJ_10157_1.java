package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        if (C * R < K) {
            System.out.println(0);
            return;
        }
        boolean[][] visit = new boolean[R][C];

        int y = 0, x = 0, dir = 0;

        for (int i = 1; i < K; i++) {
            visit[y][x] = true;

            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[ny][nx]) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            x = nx;
            y = ny;
        }
        System.out.println((x + 1) + " " + (y + 1));
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1}; // 반시계
}
// S3 자리배정 완탐
// 18분
// 그냥 DFS 안하고 풀었다.