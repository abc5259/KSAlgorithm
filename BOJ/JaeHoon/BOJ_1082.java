package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        String[][] dp = new String[N][51];
        for(int i=0; i<N; i++) {
            dp[i][arr[i]] = i + "";
        }

        for(int i=2; i<=M; i++) {
            for(int num=0; num<N; num++) {
                if(i - arr[num] < 0) continue;

                int maxLen = 0;
                for(int j=0; j<N; j++) {
                    if(dp[j][i-arr[num]] != null) {
                        maxLen = Math.max(maxLen, dp[j][i-arr[num]].length());
                    }
                }

                String max = null;
                for(int j=0; j<N; j++) {
                    if(dp[j][i-arr[num]] != null && dp[j][i-arr[num]].length() == maxLen) {
                        if(max == null) max = dp[j][i-arr[num]];
                        else {
                            if(max.compareTo(dp[j][i-arr[num]]) < 0) max = dp[j][i-arr[num]];
                        }
                    }
                }

                if(max != null) {
                    dp[num][i] = num + max;
                }else {
                    dp[num][i] = num + "";
                }
            }
        }

        int maxLen = 0;
        for(int j=0; j<N; j++) {
            if(dp[j][M] != null && dp[j][M].charAt(0) != '0') {
                maxLen = Math.max(maxLen, dp[j][M].length());
            }
        }

        String max = null;
        for(int j=0; j<N; j++) {
            if(dp[j][M] != null && dp[j][M].length() == maxLen) {
                if(max == null) max = dp[j][M];
                else {
                    if(max.compareTo(dp[j][M]) < 0) max = dp[j][M];
                }
            }
        }

        System.out.println(max == null ? "0" : max);
    }
}
