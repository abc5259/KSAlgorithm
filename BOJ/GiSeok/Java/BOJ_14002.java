/**
 * 14002 - 가장 긴 증가하는 부분 수열 4 [성공|00:11:57]
 * 골드4, LCS/DP, 시도1
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_14002 {
    // 시간제한 1초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int len = 0;
            for (int j = i-1; j >= 0; j--) {
                if (A[i] > A[j]) len = Math.max(len, dp[j]);
            }

            dp[i] = len + 1;
        }

        int idx = 0;
        for (int i = 0; i < n; i++) if (dp[i] > dp[idx]) idx = i;

        System.out.println(dp[idx]);
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for (int i = idx; i >= 0; i--) {
            if (dp[i] == dp[idx]) {
                stk.push(A[i]);
                dp[idx]--;
            }
        }

        while (!stk.isEmpty())
            System.out.print(stk.pop() + " ");
        System.out.println();
    }
}
