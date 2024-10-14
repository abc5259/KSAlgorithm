package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long[] dp = new long[s.length()+1];
        if(s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=s.length(); i++) {
            char curr = s.charAt(i-1);
            char back = s.charAt(i-2);

            if(curr != '0') {
                dp[i] = dp[i-1];
            }

            int num = (curr - '0') + (back - '0') * 10;
            if(num >= 10 && num <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % 1000000;
            }
        }

        System.out.println(dp[s.length()]);
    }
}
