/*
BaekJoon - 11057 오르막 수 (05/16 월) 

dp값을 더해줄 때 10007을 더해주는 이유는, 본래 더 큰값이 10007로 나눈 나머지값이 되면 더 작은 수가 될 수 있기 때문이다.
예를 들어 ((10007x3 + 2) % 10007 - (10007x2 + 4) % 10007) % 10007 라면 10007을 더하지 않으면 2가 붙은 쪽이 큰 수임에도 불구하고 음수가 나온다.
어쨌든 10007보다 크면 다 10007로 나눠지니까 10007만 더하면 됨!!

dp[i][j] = (dp[i][j-1] - dp[i-1][j-1] + 10007l) % 10007l;
이렇게 간단하게도 표현가능하다. 왜냐면 sum을 계속 10007로 나누기 때문에
dp에는 처음부터 10007로 나눠진 값이 들어가기 때문이다.
*/
package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+2][10];
        long sum = 0;

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
            sum += dp[1][i];
        }

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = sum % 10007l;

            sum = dp[i][0];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = ((dp[i][j-1] % 10007l) - (dp[i-1][j-1] % 10007l) + 10007l) % 10007l;
                sum += dp[i][j] % 10007l;
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++)
            result += dp[N][i] % 10007l;

        System.out.println(result % 10007l);
    }
}