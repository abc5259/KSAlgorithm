package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    static final int NUMBER = 10_007;
    static int n;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new Integer[1001];

        //dp 배열의 범위를 n+1로 초기화하면 dp[2]를 초기화 할 수 없기 때문에 오류가 발생한다 -> 1001로 범위를 초기화
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(solve(n));
    }

    static int solve(int n){
        if(dp[n] == null){
            //오버플로우가 발생하지 않게 모듈로 연산 후 dp 배열에 저장
            dp[n] = (solve(n-1) + solve(n-2)) % NUMBER;
        }
        return dp[n];
    }
}
