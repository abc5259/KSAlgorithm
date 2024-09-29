/**
 * 1344 - 축구 [실패|01:08:19]
 * 골드4, 확률/DP, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_1344 {

    static double a, b;
    static int max = 18;

    static double[][][] dp;

    static boolean isPrime(int n) {

        if (n == 0 || n == 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    static double go(int A, int B, int cnt) {

        if (cnt == max) {
            if (isPrime(A) || isPrime(B)) return 1;
            else return 0;
        }

        if (dp[A][B][cnt] != -1) return dp[A][B][cnt];

        dp[A][B][cnt] = 0;
        dp[A][B][cnt] += a * (1-b) * go(A + 1, B, cnt+1);
        dp[A][B][cnt] += (1-a) * b * go(A, B + 1, cnt+1);
        dp[A][B][cnt] += a * b * go(A + 1, B + 1, cnt+1);
        dp[A][B][cnt] += (1-a) * (1-b) * go(A, B, cnt+1);

        return dp[A][B][cnt];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        a/=100;
        b/=100;

        System.out.println(a + " " + b);

        dp = new double[max+1][max+1][max+1];
        for (int i = 0; i < max+1; i++) {
            for (int j = 0; j < max+1; j++) {
                for (int z = 0; z < max+1; z++) dp[i][j][z] = -1;
            }
        }

        System.out.println(go(0, 0, 0));
    }
}