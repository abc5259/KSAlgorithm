// 시간제한 0.5초, 메모리제한 256MB
// 자연수 N개를 칠판에 적음.
// 질문을 총 M번 한다.
// 각 질문은 두 정수 S와 E(1 <= S <= E <= N)으로 나타낼 수 있음.
// S번째 수부터 E번째까지 수가 팰린드롬인가?
/**
 * 10942 - 팰린드롬? [성공(반례힌트)|00:28:50]
 * 골드4, DP, 시도5
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            if (dp[s][e] == -1) {
                boolean flag = false;
                int ts = s;
                int te = e;
                while (ts <= te) {
                    if (nums[ts] == nums[te]) { ts++; te--; }
                    else { flag = true; break; }
                }

                if (flag) dp[s][e] = 0;
                else dp[s][e] = 1;
            }

            sb.append(dp[s][e]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush(); bw.close();
    }
}