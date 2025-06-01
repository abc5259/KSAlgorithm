package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if (dp[k] == 100001) {
            System.out.print(-1);
        } else {
            System.out.print(dp[k]);
        }
    }
}

// G4 동전 2 DP
// 일단 주어진 n개의 개수에 대한 동전을 반복해서 해당 동전에서 k까지 값이 커지게 하는 반복문을 사용한다.
// 반복문시에 현재 dp에 저장되어있는 값과 새롭게 구하는 값을 비교해서 작은것을 가져야 하는데
// dp가 0일경우 0보다 커도 0으로 저장되는 문제 trouble이 있었다.


// 그래서 dp가 가질 수 있는 100,000 값보다 큰 100,001 을 배열에 저장해두고 1원이 들어왔을 때dp[1] 의 값이 dp[1원 -1원] 인
// dp[0]에다가 +1을 해야하기에 dp[0] 은 0으로 설정해서 한다.
// 그래서 dp[j] = 원래의 dp[j] vs dp[해당 동전에서 k까지의 숫자 - 해당 동전] 한 것에 +1해준다 +1은 해당 동전이고 차액만큼
// dp로 더해주는 것이다.