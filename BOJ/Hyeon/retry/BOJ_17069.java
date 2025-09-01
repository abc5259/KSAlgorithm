package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] wall = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[N + 1][N + 1][3];

        dp[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {

                if (wall[i][j] == 1) {
                    continue;
                }

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (wall[i - 1][j] == 0 & wall[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }
        long res = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.print(res);
    }
}
// G4 파이프 옮기기 2 DP
// 일단 wall 라는 벽 배열을 입력받고 나서
// DP 상태를 정의한다 근데 가로, 세로, 대각선으로 경우의수가 나눠어져 있는데 각각 경우의 수 마다
// 횟수가 값인데 방향도 기억해야되기 때문에 3차원 배열을 사용하여 각 좌표에 파이프가 특정 방향을 도달하는 것을 기록한다.
// 1,1 부터 시작해서 1로 시작시켰다.
// 반복문은 1,3 부터 시작하면된다 왜냐면 1,3 부터 하니까 그리고 벽처리는 if continue 문으로 처리
// 가로의 경우 이전까지의 가로와 이전까지의 대각선
// 세로의 경우 이전까지의 세로와 이전까지의 대각선
// 대각선의 경우 -1,-1 이전까지의 가로와 세로, 대각선이고 이때 파이프는 왼쪽과 위가 벽이 아니어야 된다.