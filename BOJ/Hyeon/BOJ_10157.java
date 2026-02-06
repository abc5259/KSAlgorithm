package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10157 {
    static int C, R, K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        if (C * R < K) {
            System.out.println(0);
            return;
        }

        map = new int[R][C];

        map[0][0] = 1;
        dfs(0, 0, 0);
    }

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1}; // 반시계

    static void dfs(int y, int x, int dir) {
        if (map[y][x] == K) {
            System.out.println((x + 1) + " " + (y + 1));
            System.exit(0);
        }

        for (int i = 0; i < 4; i++) {
            int d = (dir + i) % 4;
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] != 0) {
                continue;
            }
            map[ny][nx] = map[y][x] + 1;
            dfs(ny, nx, d);
        }
    }
}
// S3 자리배정 DFS
// 36분
// 운좋게 푼듯?
// 일단 R 과 C 가 1000이라서 K 에 대해서 기저 사례로 탈출 조건 걸고 또
// 달팽이 문제와 유사하길래 방향 mod 연산까지 이해하고 무조건 찾게되니 길은 1개라서 그래서
// dfs 로 쭉 가다가 K 횟수일때 탈출하면 될 거 같아서 그렇게 풀었다
// 현재의 방향을 기억하기 위해 dir 도 가지고 있는데
// 근데 정답처리는 됐는데 재귀가 깊어서 스택 오버 플로우 발생 고려했다.