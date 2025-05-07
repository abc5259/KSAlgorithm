package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {
    static int N, res;
    static char[] problem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        problem = br.readLine().toCharArray();

        res = Integer.MIN_VALUE;
        dfs(2, problem[0] - '0');
        System.out.print(res);
    }

    private static void dfs(int idx, int total) {
        if (idx >= N) {
            res = Math.max(total, res);
            return;
        }
        dfs(idx + 2, cal(total, problem[idx] - '0', problem[idx - 1]));

        if (idx + 2 < N) {
            int right = cal(problem[idx] - '0', problem[idx + 2] - '0', problem[idx + 1]);

            int left = cal(total, right, problem[idx - 1]);
            dfs(idx + 4, left);
        }
    }

    private static int cal(int i, int j, char op) {
        switch (op) {
            case '+':
                return i + j;
            case '-':
                return i - j;
            default:
                return i * j;
        }
    }
}
