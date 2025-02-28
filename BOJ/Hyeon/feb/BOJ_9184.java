package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184 {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
        }
        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if (((0 < a && a < 21) && (0 < b && b < 21) && (0 < c && c < 21)) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        }
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
// 이미 구현된 함수에서 메모이제이션을 사용하여 값을 저장한 것을 불러오도록 하는 것이다.
// 더해서 범위 밖의 수를 제한하여 배열을 생성하고 그 수가 입력되면 IndexOutofBound 안하게 끔
// 조건을 처음부터 제시해주고 구한 값은 dp에 리턴 받는다.