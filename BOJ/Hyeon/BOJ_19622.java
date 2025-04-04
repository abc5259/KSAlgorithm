package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] mans = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            mans[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = mans[0];

        if (N >= 2) {
            dp[1] = Math.max(mans[0], mans[1]);
        }
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + mans[i], dp[i - 1]);
        }
        System.out.println(dp[N - 1]);
    }
}

// S2 회의실 배정 3 DP
// DP 기본 조건 분기 잘해서 점화식 찾으면 된다.
// 클래스 펼칠 필요없이 인원들로만 계산