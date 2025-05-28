package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N + 1][2];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            if (i + table[i][0] <= N + 1) {
                dp[i + table[i][0]] = Math.max(dp[i] + table[i][1], dp[i + table[i][0]]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[N + 1]);
    }
}

// G5 퇴사 2 DP
// DP 복습하면서 바텀업방식을 활용한다.
// 일단 시작일 (index) + 기간 (table[i][0]) 이 N+1 보다 작거나 같아야된다.
// 이는 퇴사하는날에 상담이 끝날 수 있기 때문에
// 만약 N이 1이고 기간이 1이면 1일날 상담하고 N이 1이라서 2일날 퇴사인데
// 2일날 퇴사날에 상담이 끝나는건 가능해야 되기때문이다.
// 퇴사날의 값은 N+1 인덱스이기에 dp는 N+2로 만들어야된다.

// 시작일 + 기간에 해당하는 날에 기존에 가지고있던 상담의 최고값 vs 현재까지 인덱스 까지의 상담값 + table[i][1] 의 값을 비교해서
// 큰깂을 가지고 만약 시작일 + 기간이 N+1을 초과한다면 이전의 dp값을 가져와야 해서 dp[i+1] = dp[i]와 dp[i+1]을 한다.