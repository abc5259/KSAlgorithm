/**
 * [S2 LIS] 가장 큰 증가하는 부분 수열 - O, 00:34:25
 * 시도 3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            ret = Math.max(dp[i], ret);
        }

        System.out.println(ret);
    }
}
