package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n] + " " + (n - 2));
    }
}

// B1 알고리즘 수업 - 피보나치 수 1 DP
// 재귀와 DP의 차이
// 재귀는 반복해서 호출해야되는데 dp에 가진 값 자체가 dp의 재귀호출 횟수이다. 이는
// 1과 2인덱스가 1로 가지는 값을통해서 재귀를 해서 기저 사례로 탈출하는 것인데 n이라는 주어진 값이 1이나 2로 반환해서 탈출해서 재귀의 총합을 구하기에
// 이는 실행 횟수와 관계가 있다.