package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[65][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += dp[n][i];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}

// S1 줄어들지 않아 DP
// 일단 고려하자면 3중 반복문을 쓴다 왜냐하면 현재 dp[i][0]의 경우 [i-1][0]~[i-1][9]까지의 합과 같다
// 이와같이 dp의 값을 계산할 때 행의 인덱스 -1 과 뒤의 열의 인덱스 부터 시작해서9까지의 합을 계싼해서 해당 dp에 넣어준다
// 그리고 우리가 구하고자하는 총 합은 dp 반복문을 통해 총합을 계산한다.