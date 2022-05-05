/*
BaekJoon - 2133 타일 채우기 (05/05 목)

하나씩 찾아보면,
dp[2] = 3
dp[4] = (dp[2] * dp[2]) + 2
dp[6] = (dp[4] * dp[2]) + (2 * dp[2]) + 2
dp[8] = (dp[6] * dp[2]) + (2 * dp[4]) * (2 * dp[2]) + 2

라는 것을 알 수 있음. (dp[4] * dp[2])는 간단하니, (2 * dp[4]) ... 부분만 구현하면 된다.
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Baek_2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+3];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for (int i = 3; i < N+1; i++)
            if (i % 2 == 0) {
                dp[i] = (dp[i-2] * dp[2]);
                for (int j = 4; j <= i; j+=2)
                    dp[i] += (2*dp[i-j]);
            }
            else
                dp[i] = 0;
        
        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }
}