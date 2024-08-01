package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_2 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N];

        int ret = 0;
        for (int i = 0; i < N; i++) {
            int value = 0;
            for (int j = 0; j < i; j++)
                if (A[j] < A[i] && value < dp[j]) value = dp[j];

            dp[i] = value + 1;
            ret = Math.max(ret, dp[i]);
        }

        System.out.println(ret);
    }
}
