package BOJ.Hyeon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(com(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    public static int com(int n, int r) {

        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        return dp[n][r] = com(n - 1, r - 1) + com(n - 1, r);
    }
}
// 전형적인 조합에 관련된 문제로 dp를 통해 메모이제이션을 활용하려한다.
// 해당 N과 M의 값을 dp 배열로 만들어서 저장한 후 이를 불러와서 사용한다.
// 0보다 큰 경우는 이미 메모된 경우를 찾는 것이고, n이 r과 같은 경우 혹은 r이 0일때는 항상 1값을 리턴한다.