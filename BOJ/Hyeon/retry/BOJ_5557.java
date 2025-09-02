package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N - 1][21];
        dp[0][arr[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[i - 1][j] == 0) {
                    continue;
                }
                int plus = j + arr[i];
                if (plus <= 20) {
                    dp[i][plus] += dp[i - 1][j];
                }
                int minus = j - arr[i];
                if (minus >= 0) {
                    dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        System.out.print(dp[N - 2][arr[N - 1]]);
    }
}
// G5 1학년 DP 좋은 문제 또 풀면 좋을듯?
// 일단 접근 자체가 제일 처음 숫자부터 해서 마지막 전까지의 경우의 수를 구한다
// dp 이기 때문에 +와 -를 분기해서 값을 저장해야되는데 범위가 0부터 20까지로 정해줬기 때문에
// N의 개수에 따른 열의 개수 21이다 근데 N은 맨마지막은 사실상 입력값으로 쓸꺼기 떄문에 필요없어서 dp 의 행은 N-2까지만 쓰면된다.
// i까지 썼을 때의 계산 결과의 가짓수를 저장하는 dp 로
// arr[0]은 8인데 그럼 dp[0][8] 이 1개가 있고 dp[1] 부터 8에서 +arr[i]와 -arr[i]를 하며 dp 누적으로 진행하면된다
// 이때 plus 와 minus의 조건에 따라 움직여야하고 이전 dp의 값이 0이면 그냥 건너뛴다.
// 점화식은 바텀업을 통해서 작은거부터 i-1번째 계산결과가j였던 경우의 수를 plus에 그대로 증가해버린다.
// 결과는 N-2 인덱스 까지의 수만 연산할거고 우리가 구하고자하는 arr[N-1] 끝 수의 경우의 수이다.