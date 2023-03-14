package BOJ.GiSeok.Java.retry;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            if (dp[i] == 0) dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    if (dp[i] < dp[j]+1)
                        dp[i] = dp[j]+1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }
}
