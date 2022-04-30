package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_1463 {
    public static int inspect(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < n+1; i++) {
            if (i%3 == 0) {
                dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
                if (i%2 == 0)       // 최소 공배수 6을 고려하기 위한 조건문,,
                    dp[i] = Math.min(dp[i], dp[i/2]+1); 
            }
            else if (i%2 == 0)
                dp[i] = Math.min(dp[i-1], dp[i/2]) + 1; 
            else
                dp[i] = dp[i-1] + 1;
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = inspect(N);

        System.out.println(num);
    }
}