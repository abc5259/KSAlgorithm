package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        System.out.println(fibo(n));
    }

    static long fibo(int n) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }
        if (dp[n] == 0) {
            dp[n] = fibo(n - 1) + fibo(n - 2);
        }
        return dp[n];
    }
}

// B1 피보나치 수 2 DP
// DP 단원 풀면서 단계별 풀어보기 다 풀려고 오랜만에 풀어봣다 매번 Bottom up 방식으로
// DP를 풀어왔었는데 재귀, 분할정복을 하면서 Top Down 방식도 써봤다.
// 재귀를 다뤄서 DP를 쓰니까 반복되는 호출을 dp의 배열 접근으로 시간을 줄일 수 있었고
// 90이라는 주어진 수는 되게 커서 long 타입으로 가져와야만 했다. 그리고 0부터 90까지라 n+1 하였다.