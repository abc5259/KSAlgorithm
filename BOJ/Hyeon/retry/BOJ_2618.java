package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());

        int[][] accident = new int[W + 1][2];
        StringTokenizer st;
        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            accident[i][0] = Integer.parseInt(st.nextToken());
            accident[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[W + 1][W + 1];

        for (int i = 0; i <= W; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        Point[][] path = new Point[W + 1][W + 1];

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < W; j++) {

                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }

                int nextIncident = Math.max(i, j) + 1;

                int policeCar1X = (i == 0) ? 1 : accident[i][0];
                int policeCar1Y = (i == 0) ? 1 : accident[i][1];
                int dis1 = calculateDistance(policeCar1X, policeCar1Y, accident[nextIncident][0], accident[nextIncident][1]);
                int cost1 = dis1 + dp[i][j];

                if (cost1 < dp[nextIncident][j]) {
                    dp[nextIncident][j] = cost1;
                    path[nextIncident][j] = new Point(i, j);
                }

                int policeCar2X = (j == 0) ? N : accident[j][0];
                int policeCar2Y = (j == 0) ? N : accident[j][1];
                int dis2 = calculateDistance(policeCar2X, policeCar2Y, accident[nextIncident][0], accident[nextIncident][1]);
                int cost2 = dis2 + dp[i][j];
                if (cost2 < dp[i][nextIncident]) {
                    dp[i][nextIncident] = cost2;
                    path[i][nextIncident] = new Point(i, j);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int finalI = 0, finalJ = 0;

        for (int i = 0; i < W; i++) {
            if (dp[W][i] < ans) {
                ans = dp[W][i];
                finalI = W;
                finalJ = i;
            }
            if (dp[i][W] < ans) {
                ans = dp[i][W];
                finalI = i;
                finalJ = W;
            }
        }
        System.out.println(ans);

        StringBuilder sb = new StringBuilder();

        while (finalI != 0 || finalJ != 0) {
            Point tmp = path[finalI][finalJ];

            if (path[finalI][finalJ].x == finalJ) {
                sb.insert(0, "1\n");
            } else {
                sb.insert(0, "2\n");
            }
            finalI = tmp.y;
            finalJ = tmp.x;
        }
        System.out.print(sb);
    }

    private static int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
// P4 경찰차 DP
// 일단 생각해야될게 경찰차가 2대가 있고 이동거리를 구해야되는게 1번
// 2번은 좌표가 필요하다 이전 경찰차의 좌표 그리고 역추적을 위한 경찰차 번호를 기억해야되는데 이를 위한 배열까지
// 그런데 좌표를 배열해야되니까 Point 클래스를 생성했고
// 거리 계산을 위해 절대값으로 메소드 뺏다. 사건들의 배열을 만들어서 접근 하게 했다.
// 1. DP 상태를 dp[i][j] = 1번 경찰차가 i 번 2번 경찰차가 j 번 사건을 하고 있다라고 상태를 만든다.
// 2. 바텀업으로 해서 dp[i][j] 상태에서 다음 사건 => max 로 i와 j 의 최대를 전이하게 끔한다.
// dp 테이블 갱신해서 path 배열에 Point 객체 저장