package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<3; t++) {


            int N = Integer.parseInt(br.readLine());
            int sum = 0;

            int[][] coins = new int[N][2];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());

                sum += value * cnt;
                coins[i] = new int[]{value, cnt, value * cnt};
            }

            if(sum % 2 == 1) {
                sb.append(0).append("\n");
            }else {
                int mid = sum / 2;
                boolean[][] dp = new boolean[N+1][mid+1];

                dp[0][0] = true;

                for(int i=0; i<N; i++) {
                    int[] coin = coins[i];
                    for(int j=0; j<=Math.min(mid,coin[2]); j++) {
                        if(!dp[i][j]) continue;

                        if(j+coin[0] <= mid) {
                            dp[i][j+coin[0]] = true;
                        }
                        dp[i+1][j] = true;
                    }
                }

                if(dp[N][mid]) {
                    sb.append(1).append("\n");
                }else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
