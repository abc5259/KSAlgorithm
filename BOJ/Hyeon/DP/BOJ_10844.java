package BOJ.Hyeon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
//         일단 설명하자면 2차원 배열로 구성하여서, 자리수와 그에 해당하는 숫자를 메모이제이션을한다.
//         2자리일 경우 1자라에다가 추가하는 점화식이기 때문이다.
//         1자리는 1~9까지 모든 수가 가능하고 0은 불가능해서 가능한 1자리의 0~9 dp에 경우의수 1을 대입한다.
        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[N][i];
        }
        System.out.println(res % 1_000_000_000);
    }
}
// 2자리 부터는 0이나 9가 올경우 1자리에는 항상 1과 8만 가능하다 그렇기 때문에 경우의수를 이어받는다.
// 왜냐하면 해당 자리의 0이나 9가 왔을 경우 이전 값의 1이나 8을 그대로 전달하기 때문이다.
// 나머지는 2자리의 2일 경우 1자리의 1이나 1자리의 3의 경우를 가져올 수 있어서 저렇게 연산한다.