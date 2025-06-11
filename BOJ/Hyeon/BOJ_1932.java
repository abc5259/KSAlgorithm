package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] dp = new int[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    dp[i][j] = tmp;
                } else {
                    if (j == 0) {
                        dp[i][j] = tmp + dp[i - 1][j];
                    } else if (j == i) {
                        dp[i][j] = tmp + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tmp;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);

    }
}

// S1 정수 삼각형 DP
// 다시 풀었음 쉽네
// dp 배열을 만들어서 파스칼 삼각형 처럼 연산한다. 양 끝은 항상 가짓수가 1개고
// 나머지들은 가짓수가 다양하기 떄문에 dp 배열을 생성하고 이를 누적합 개념으로 계산한다.
// 양 옆의 경우를 조건 분기하여 계산하고, 가운데 부분을 최대값을 통해 선택된 dp에 배열하는
// 메모이제이션을 활용하여 재활용한 값을 통해 최대값을 반환한다.