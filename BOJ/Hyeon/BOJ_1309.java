package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1309 {
    private final static int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[100_001];

        dp[1] = 3;
        dp[2] = 7;

        for (int i = 3; i <= N; i++) {
            dp[i] = ((dp[i - 1] % MOD * 2) % MOD + dp[i - 2]) % MOD;
        }
        System.out.println(dp[N]);
    }
}
// S1 동물원 DP
// 이거 그냥 규칙을 찾아버렸다.
// DP 배열을 통해 N이 1일 때부터 해서 N이 4일때까지 주어진 TC 를 41을 이용했다.
// 점화식을 통해서 구축했고 항상 N개의 사자가 있다면 N번째는 2개이고 그래서
// N이 1일때 3, 7 , 17 , 41 이렇게 되어있어서 점화식을 통해
// 앞수 i-1*2+ i-2였다.

/*
내가 고민하는건 DP 라는 점화식을 이해하기 어려울 수 도 있겠다 생각
마냥 규칙을 찾는거보다.. 왜 이런 점화식이 되었는지 이해하는 방법
사자의 위치에 대한 2차원 배열로 경우의수를 분배
 */