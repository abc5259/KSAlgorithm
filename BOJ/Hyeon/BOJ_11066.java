package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11066 {
    static int[][] dp;
    static int[] sum;
    static int[] chapter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;


        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            chapter = new int[K + 1];
            sum = new int[K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                chapter[i] = Integer.parseInt(st.nextToken());
                sum[i] = chapter[i] + sum[i - 1];
            }


            dp = new int[K + 1][K + 1];

            for (int len = 2; len <= K; len++) {
                for (int start = 1; start <= K - len + 1; start++) {
                    int end = start + len - 1;

                    dp[start][end] = Integer.MAX_VALUE;

                    for (int k = start; k < end; k++) {

                    }
                    
                }
            }
        }
        System.out.print(sb);
    }
}
