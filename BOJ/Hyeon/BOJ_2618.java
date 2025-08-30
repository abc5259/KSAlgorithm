package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int[][] path1 = new int[W + 1][W + 1];
        int[][] path2 = new int[W + 1][W + 1];

        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < W; j++) {
                if (i > 0 && j > 0 && dp[i][j] == 0) {
                    continue;
                }

                int nextIncident = Math.max(i, j) + 1;
                if (nextIncident > W) {
                    continue;
                }

                int police1CarX = (i == 0) ? 1 : accident[i][0];
                int police1CarY = (i == 0) ? 1 : accident[i][1];
                int dis1 = calculateDistance(police1CarX, police1CarY, accident[nextIncident][0], accident[nextIncident][1]);
                int newCost1 = dp[i][j] + dis1;

                if (dp[nextIncident][j] == 0 || newCost1 < dp[nextIncident][j]) {
                    dp[nextIncident][j] = newCost1;
                    path1[nextIncident][j] = i;
                    path2[nextIncident][j] = j;
                }

                int police2CarX = (j == 0) ? N : accident[j][0];
                int police2CarY = (j == 0) ? N : accident[j][1];
                int dis2 = calculateDistance(police2CarX, police2CarY, accident[nextIncident][0], accident[nextIncident][1]);
                int newCost2 = dp[i][j] + dis2;

                if (dp[i][nextIncident] == 0 || newCost2 < dp[i][nextIncident]) {
                    dp[i][nextIncident] = newCost2;
                    path1[i][nextIncident] = i;
                    path2[i][nextIncident] = j;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        int final_i = 0, final_j = 0;

        for (int j = 0; j < W; j++) {
            if (dp[W][j] < minDistance) {
                minDistance = dp[W][j];
                final_i = W;
                final_j = j;
            }
        }
        for (int i = 0; i < W; i++) {
            if (dp[i][W] < minDistance) {
                minDistance = dp[i][W];
                final_i = i;
                final_j = W;
            }
        }
        System.out.println(minDistance);


        int[] resultPath = new int[W + 1];
        int current_i = final_i;
        int current_j = final_j;

        while (current_i > 0 || current_j > 0) {
            int prev_i = path1[current_i][current_j];
            int prev_j = path2[current_i][current_j];

            if (current_i > prev_i) {
                resultPath[current_i] = 1;
            } else {
                resultPath[current_j] = 2;
            }
            current_i = prev_i;
            current_j = prev_j;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= W; i++) {
            sb.append(resultPath[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

// P4 경찰차 DP
// retry 반복 학습 중 일단 역추적이랑 accident까지 다루고 dp 배열이해중