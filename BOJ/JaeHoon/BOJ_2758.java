package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2758 {
    static int N, M;
    static long[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        memo = new long[2001][11];
        for(int i=1; i<=2000; i++) {
            Arrays.fill(memo[i], -1);
        }
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            long sum = 0;
            for(int i=M; i>=1; i--) {
                long solve = solve(N, i);
                sum += solve;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
    static long solve(int depth, int start) {
        if(depth == 1) {
            return 1;
        }

        if(memo[start][depth] != -1) {
            return memo[start][depth];
        }

        long sum = 0;
        for(int i=start/2; i>=1; i--) {
            sum += solve(depth-1, i);
        }
        memo[start][depth] = sum;

        return memo[start][depth];
    }
}
