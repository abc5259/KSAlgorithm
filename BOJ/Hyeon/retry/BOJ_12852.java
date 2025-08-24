package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] path = new int[N + 1];


        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(dp[N]).append("\n");
        int tmp = N;

        while (tmp > 0) {
            sb.append(tmp).append(" ");
            tmp = path[tmp];
        }
        System.out.print(sb);
    }
}
// S1 1로 만들기 2 DP
// 다시 풀었는데 좋은 문제같아서 다음에 풀어도 좋을듯
// 크게 2개의 실수를 했다
// 잘못된 접근 1
// N부터 계산하게 Top-down으로 고려했는데 10에서 1로 가야되니까
// 10 9 3 1 이렇게 가는데 만약 10에서 9로가고 10에서 5로갈 수 있는데 dp에 대해 9와 5의 결과를 아직 알지 못한다
// 이는 탑다운으로 했을 때 작은 단위로 계산이 되어야만 하고 메모이제이션을 이용한다면 반복문이 아닌 재귀를 써서 했어야 했다
// 잘못된 접근 2
// i%2==0 과 i%3==0 일 때 덮어쓰기 문제
// dp[6] = dp[3] + 1인데 dp[6] = dp[5] +1일 수도 있다. 근데 i에서 i*2를 미리 설정해버려서 비교가 안된다
// 바텀업 법칙 위배도 있다. i의 값은 이미 확정된거랑 비교해야되는데 미래의 값을 예측하면 안된다. 바텀업은