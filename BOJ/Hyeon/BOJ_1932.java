package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dp = new int[n][n];
        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col <= row; col++) {
                dp[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int max = dp[0][0];
        for (int row = 1; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0) {
                    dp[row][col] += dp[row - 1][col];
                } else if (col == row) {
                    dp[row][col] += dp[row - 1][row - 1];
                } else {
                    dp[row][col] += Math.max(dp[row - 1][col - 1], dp[row - 1][col]);
                }
                max = Math.max(max, dp[row][col]);
            }
        }
        System.out.println(max);
    }
}
// dp 배열을 만들어서 파스칼 삼각형 처럼 연산한다. 양 끝은 항상 가짓수가 1개고
// 나머지들은 가짓수가 다양하기 떄문에 dp 배열을 생성하고 이를 누적합 개념으로 계산한다.
// 양 옆의 경우를 조건 분기하여 계산하고, 가운데 부분을 최대값을 통해 선택된 dp에 배열하는
// 메모이제이션을 활용하여 재활용한 값을 통해 최대값을 반환한다.