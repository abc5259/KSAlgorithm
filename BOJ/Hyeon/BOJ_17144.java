package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144 {
    static int R, C;
    static int[][] map; // 원본
    static int[][] res; // 확산

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        res = new int[R][C];

        int airY = 0, airX = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    airY = i;
                    airX = j;
                }
            }
        }

        int ans = 2;

        while (T-- > 0) {
            for (int i = 0; i < R; i++) {
                Arrays.fill(res[i], 0);
            }

            spread();

            for (int c = airX + 1; c < C - 1; c++) {
                map[airY][c + 1] = res[airY][c];
            }

            for (int r = airY; r < R - 1; r++) {
                map[r + 1][C - 1] = res[r][C - 1];
            }

            for (int c = C - 1; c > airX; c--) {
                map[R - 1][c - 1] = res[R - 1][c];
            }

            for (int r = R - 1; r > airY; r--) {
                map[r - 1][airX] = res[r][airX];
            }

            for (int c = airX + 1; c < C - 1; c++) {
                map[airY - 1][c + 1] = res[airY - 1][c];
            }

            for (int r = airY - 1; r > 0; r--) {
                map[r - 1][C - 1] = res[r][C - 1];
            }

            for (int c = C - 1; c > airX; c--) {
                map[0][c - 1] = res[0][c];
            }

            for (int r = 0; r < airY - 1; r++) {
                map[r + 1][airX] = res[r][airX];
            }
            map[airY][airX + 1] = 0;
            map[airY - 1][airX + 1] = 0;

            map[airY - 1][airX] = -1;
            map[airY][airX] = -1;
        }

        for (int[] row : map) {
            for (int val : row) {
                ans += val;
            }
        }
        System.out.println(ans);
    }

    static void spread() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int tmp = map[i][j] / 5;

                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1) {
                            continue;
                        }
                        res[ny][nx] += tmp;
                        cnt++;
                    }
                    res[i][j] += (map[i][j] - tmp * cnt);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            System.arraycopy(res[i], 0, map[i], 0, C);
        }
    }

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
}
// G4 미세먼지 안녕!
// 1시간 30분
// 아니 자꾸 문제가 생겨서 디버깅 했는데 알고보니 공기청정기 역할을 안했었음
// 그리고 4방향에 대해서 그냥 res 배열 만드는 건 쉬웟는데
// 값을 깊은 복사를 해서 도미노를 방지했더니 코드가 헷갈리고 또 메소드화 시키려했는데 실패해서 오래걸림
// 잘못된 부분 포착이 매우느렸음.