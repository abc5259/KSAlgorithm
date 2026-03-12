package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_21608 {

    // 교실은 N*N
    // 학생 수 N^2

    // 1. 비어 있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함
    // 2. 1을 만족하는 칸이 여러 개면, 인접한 칸 중 비어있는 칸이 가장 많은 칸
    // 3. 2를 만족하는 칸도 여러 개면
    //    - 행 번호가 작은 칸
    //    - 행도 다 같으면 열 번호가 가장 작은 칸

	/*
	(0, 0) (0, 1) (0, 2)
	(1, 0) (1, 1) (1, 2)
	(2, 0) (2, 1) (2, 2)

	1 - 0 + 1- 0 = 2

	상하좌우만 인접임
	*/

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] likes = new int[n * n + 1][4];
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++)
                likes[student][j] = Integer.parseInt(st.nextToken());

            int maxFavorite = 0;
            int maxEmpty = -1;
            int my = 0;
            int mx = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[y][x] != 0) continue;

                    int like = 0;
                    int empty = 0;
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];

                        if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                        if (map[ny][nx] == 0) {
                            empty++;
                            continue;
                        }

                        for (int f = 0; f < 4; f++) {
                            if (likes[student][f] == map[ny][nx]) like++;
                        }
                    }

                    // 우선순위가 선호도 가장 많은 칸이므로 선호도 기준으로 앞에서 갱신해주고,
                    // 선호도가 같은게 여러 개이면 empty를 기준으로 갱신한다.
                    // 둘 다 같은게 많으면? empty를 기준으로 첫 갱신되는 애가 y, x 반복문 순서상 제일 빠르므로 한 번 갱신.
                    // ----------------> 이거 때문에 maxEmpty = -1로 초기화. 그래야 like 같은 거 여러 개일 때
                    // 처음 만난 놈으로 갱신되고, 이후 갱신x
                    if (like > maxFavorite || (like == maxFavorite && empty > maxEmpty)) {
                        maxFavorite = like;
                        maxEmpty = empty;
                        my = y;
                        mx = x;
                    }
                }
            }

            map[my][mx] = student;
        }

        // 만족도 조사
        int ans = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                    for (int f = 0; f < 4; f++) {
                        if (likes[map[y][x]][f] == map[ny][nx]) cnt++;
                    }
                }

                ans += (cnt == 0 ? 0 : (int) Math.pow(10, cnt-1));
            }
        }

        System.out.println(ans);
    }
}
