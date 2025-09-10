package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 무조건 다시 풀기
public class BOJ_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N + 1][2];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 2; i <= N; i++) {
            for (int start = 1; start <= N - i + 1; start++) {
                int end = start + i - 1;
                dp[start][end] = Integer.MAX_VALUE;

                for (int k = start; k < end; k++) {
                    int cost = dp[start][k] + dp[k + 1][end] + matrix[start][0] * matrix[k][1] * matrix[end][1];
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}

// G3 행렬 곱셈 순서 DP
// 너무 어렵다 접근자체를 잘 모르겠다.
// 행렬곱셈 결합 법칙은 순서에 따라 연산 횟수가 달라짐
// DP 상태 정의 i번째 행렬부터 J번쨰 행렬까지 곱하는 연산횟수
// 기억할 정보 : 최소비용이라는 숫자만 dp 테이블에 기록 [1][N]

// [i][j] 계산 위해서 k를 이요해서 2가지로 i k / k+1 j
