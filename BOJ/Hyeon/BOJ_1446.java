package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dp = new int[D + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for (int j = 0; j < N; j++) {
                if (arr[j][1] == i) {
                    dp[i] = Math.min(dp[arr[j][0]] + arr[j][2], dp[i]);
                }
            }
        }
        System.out.println(dp[D]);
    }
}

// S1 지름길 DP
// 좋은 문제 일단 dp[i-1] + 1,과 dp[i]를 비교하면서
// 만약 arr[][1] 이 dp[i]랑 같을 때에 비교를 해야한다.
// 그거에 대한 최소값을 기입해야됨