package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i - j] + arr[j], dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}

// S1 카드 구매하기 2 DP
// 걍 쉽게 풀었다.
// 카드팩 마다 최소의 가격을 구해야 하는데 만약 3팩을 살 때를 고려하자면
// 2팩까지의 최소가격과 1개를 각각 구매 dp[2] + arr[1] 이고
// 1팩까지의 최소가격과 2개를 각각 구매 dp[1] + arr[2] 이고
// 0팩까지의 최소가격과 3개를 구매하니까 [dp[0]==0] + arr[3] 이다.
// 그리고 계속해서 dp[i] 와 비교한다 최소값을