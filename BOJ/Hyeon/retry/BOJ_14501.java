package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            if (i + table[i][0] <= N) {
                dp[i + table[i][0]] = Math.max(dp[i] + table[i][1], dp[i + table[i][0]]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.print(dp[N]);
    }
}

// S3 퇴사 DP
// 아 어렵게 풀었다
// 점화식 접근이 어려웠고 인덱스 관리가 힘들었다.

// 일단 기존의 테이블을 자료로 사용하고 dp 로 가능한 받을 수 있는 금액을 만들어서 메모이제이션으로 비교해가면서 쓴다
// 만약 상담이 퇴사전에 되는것이라면 dp에 종료 날 dp 에 값을 넣는데 이때 기존에 가지고 있던 최대값이랑
// 현재 내가 회의를 끝내서 얻을 수 있는 금액과 지금까지의 dp 의 합산의 max 비교를 통해 dp에 저장하고
// 다음 dp를 미룬다. 최대값으로