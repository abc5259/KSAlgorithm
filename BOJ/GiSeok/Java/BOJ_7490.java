/**
 * [G5 문자열] 0 만들기 - O, 01:03:46
 * 시도 3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7490 {

    private static StringBuilder sb = new StringBuilder();
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, "");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n, String exp) {
        if (n == N) {
            exp += n;
            String replace = exp.replace(" ", "");
            if (sum(replace) == 0) {
                sb.append(exp).append("\n");
            }
            return;
        }

        dfs(n + 1, exp + n + " ");
        dfs(n + 1, exp + n + "+");
        dfs(n + 1, exp + n + "-");
    }

    private static int sum(String exp) {
        int sum = 0;
        int num = 0;
        int e = 1;
        for (int i = exp.length() - 1; i >= 0; i--) {
            switch (exp.charAt(i)) {
                case '+':
                    sum += num;
                    num = 0;
                    e = 1;
                    break;
                case '-':
                    sum -= num;
                    num = 0;
                    e = 1;
                    break;
                default:
                    if (num == 0) num = exp.charAt(i) - '0';
                    else num = num + ((exp.charAt(i) - '0') * e);
                    e *= 10;

                    if (i == 0) sum += num;
            }
        }

        return sum;
    }
}
