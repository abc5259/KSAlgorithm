package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
    static int N;
    final static int MOD = 1000;
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }
        int[][] res = pow(origin, B);

        StringBuilder sb = new StringBuilder();
        for (int[] re : res) {
            for (int i : re) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] pow(int[][] A, long e) {
        if (e == 1L) {
            return A;
        }
        int[][] ret = pow(A, e / 2);

        ret = multiply(ret, ret);

        if (e % 2 == 1L) {
            ret = multiply(ret, origin);
        }
        return ret;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += a[i][k] * b[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}
// G4 행렬제곱 재귀
