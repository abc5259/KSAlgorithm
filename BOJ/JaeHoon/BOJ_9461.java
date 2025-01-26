package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {
    public static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        memo = new long[101];
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(f(N)).append('\n');
        }
        System.out.print(sb);
    }

    public static long f(int n) {
        if(memo[n] != 0) return memo[n];
        return memo[n] = f(n-2) + f(n-3);
    }
}
