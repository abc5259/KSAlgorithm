/*
BaekJoon - 1912 연속합 (05/13 금) 

연속해서 더하는 수가 어느 순간 0보다 작으면 그 다음 수부터 다시 연속해서 더해보면 됨
*/
package BOJ.GiSeok.Java;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            dp[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            if (dp[i-1] < 0)
                continue;
            else
                dp[i] = dp[i] + dp[i-1];
        }

        int num = dp[0];
        for (int i = 1; i < N; i++)
            num = Math.max(num, dp[i]);

        System.out.println(num);
    }
}