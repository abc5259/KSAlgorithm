package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i][j - 1];
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int i = y1; i <= y2; i++) {
                sum += dp[i][x2] - dp[i][x1 - 1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}

// S1 구간 합 구하기 DP
// 누적합을 써야한다 왜냐하면 M의 범위가 100_000이고
// y와 x 또한 1000까지 가능하기 때문에 2중 반복문 * M은 시간초과를 발생했다 그래서
// dp의 누적합을 사용하였고 행단위로 누적합을해서 시작인덱스 -1을 해주면된다.