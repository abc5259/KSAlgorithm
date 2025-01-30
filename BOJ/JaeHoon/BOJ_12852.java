package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12852 {
    static int[] dp = new int[1000001];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        System.out.println(solve(N));
        solve2(N);
        System.out.println(sb);
    }
    static int solve(int n) {
        if(dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;
        if(n % 3 == 0) {
            min = solve(n/3);
        }
        if(n % 2 == 0) {
            min = Math.min(solve(n/2), min);
        }
        min = Math.min(min, solve(n-1));
        return dp[n] = min + 1;
    }

    static void solve2(int n) {
        if(n == 1) {
            sb.append(n).append(" ");
            return;
        }
        sb.append(n).append(" ");
        if(n % 3 == 0 && n % 2 == 0) {
            if(dp[n/3] <= dp[n-1]) {
                if(dp[n/2] <= dp[n/3]) {
                    solve2(n/2);
                }
                else {
                    solve2(n/3);
                }
            }
            else if(dp[n/2] <= dp[n-1]) {
                solve2(n/2);
            }else {
                solve2(n-1);
            }
        }
        else if(n % 3 == 0) {
            if(dp[n/3] <= dp[n-1]) {
                solve2(n/3);
            }
            else {
                solve2(n-1);
            }
        }
        else if(n % 2 == 0) {
            if(dp[n/2] <= dp[n-1]) {
                solve2(n/2);
            }
            else {
                solve2(n-1);
            }
        }else {
            solve2(n-1);
        }
    }
}
