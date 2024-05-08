package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bReader.readLine());

        for(int tc=0; tc<T; tc++) {
            int n = Integer.parseInt(bReader.readLine());
            int[] dp = new int[11];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i=4; i<=10; i++) {
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }

            System.out.println(dp[n]);
        }


    }
}