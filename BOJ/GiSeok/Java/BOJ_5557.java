/**
 * 5557 - 1학년 [성공|01:10:44]
 * 골드5, DP, 시도1
 */
package BOJ.GiSeok.Java;

import java.util.*;
import java.io.*;

public class BOJ_5557 {
    static int n;
    static int[] nums;
    static long[][] dp;

    static long go(int n1, int sum) {

        if (dp[n1][sum] != -1) return dp[n1][sum];
        if (n1 == n-1) {
            if (sum == nums[n1]) return 1;
            else return 0;
        }

        dp[n1][sum] = 0;
        if (sum + nums[n1] >= 0 && sum + nums[n1] <= 20) dp[n1][sum] += go(n1 + 1, sum + nums[n1]);

        if (sum - nums[n1] >= 0 && sum - nums[n1] <= 20) dp[n1][sum] += go(n1 + 1, sum - nums[n1]);

        return dp[n1][sum];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new int[n];
        dp = new long[n][21];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        System.out.println(go(1, nums[0]));
    }
}