package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] score = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }
        int[][] dp = new int[N+1][2];
        int[] sum = new int[N+1];

        dp[1][0] = score[1];
        dp[1][1] = score[1];
        dp[2][0] = Math.min(score[1],score[2]);
        dp[2][1] = Math.max(score[1],score[2]);
        sum[2] = dp[2][1] - dp[2][0];
        for(int i=3; i<=N; i++) {
            //1. 해당 학생을 이전 조와 합친다.
            int min = Math.min(score[i],dp[i-1][0]);
            int max = Math.max(score[i],dp[i-1][1]);
            int add = max - min - (dp[i-1][1] - dp[i-1][0]);
            int sum1 = sum[i-1] + add;

            //2. 이전학생과 현재 학생을 같은조로 묶는다.
            int sum2 = sum[i-2] + Math.max(score[i],score[i-1]) - Math.min(score[i],score[i-1]);


            if(sum1 > sum2) {
                dp[i][0] = min;
                dp[i][1] = max;
                sum[i] = sum1;
            }else {
                dp[i][0] = Math.min(score[i],score[i-1]);
                dp[i][1] = Math.max(score[i],score[i-1]);
                sum[i] = sum2;
            }

        }
        System.out.println(sum[N]);
    }
}
