/*
BaekJoon - 2156 포도주 시식 (05/18 수)

*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baek_2156 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 3];
        int[] wine = new int[N + 2];

        wine[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(br.readLine());
            wine[i] = num;
        }
        
        dp[0] = 0;
        dp[1] = wine[1];
        dp[2] = wine[2] + wine[1];

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i-2] + wine[i]), dp[i-3] + wine[i - 1] + wine[i]);
        }

        System.out.println(dp[N]);
    }
}