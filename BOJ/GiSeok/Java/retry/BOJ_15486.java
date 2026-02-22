package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 남은 N일동안 최대한 많은 상담 할거임
        // 퇴사하는 날 전에 비용이 최대가 되는 상담들을 골라야된다.
        // 기간이라는 상태값이 다음 선택에 영향을 준다.

        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            num[i][0] = t;
            num[i][1] = p;
        }

        /**
         * 왜 앞 -> 뒤 탐색은 할 수 없나?
         * 1일부터 i일까지의 최대 이익이라고 하면, i일에서는 1일 ~ i-1일까지 어떤 순서로 와서 최대이익이 된건지 알아야 한다.
         * 즉, 순서를 기억해야 한다. 그래서 경우의 수도 많아짐.
         * 하지만 뒤 -> 앞 탐색으로 하면
         * i일부터 n일까지의 최대 이익이 되고, 이 경우엔 i + t[i]로 확정됨.
         * i + t[i] ~ n 까지라고 볼 수 있으나 순서를 기억할 필요도 없고
         * i + t[i] 또한, i + t[i] ~ n일 까지의 최대 이익이라고 한다면 하나의 탐색만으로 구할 수 있다는 것이다.
         */
        int[] dp = new int[n+2];
        for (int i = n; i >= 0; i--) {
            // 가능한 선택지는 i일에 상담을 하냐, 하지 않느냐이다.
            // dp는 가능한 선택지를 모두 나열하는 것이 중요
            if (i + num[i][0] > n + 1) dp[i] = dp[i + 1];
            else dp[i] = Math.max(dp[i + 1], num[i][1] + dp[i + num[i][0]]);
        }

        System.out.println(dp[0]);
    }
}
