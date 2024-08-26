/**
 * 24416 - 알고리즘 수업 - 피보나치 수 1 [성공|00:05:16]
 * 브론즈1, DP, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24416 {
    // 시간제한 1초, 메모리제한 512MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] f = new int[n + 1];

        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++)
            f[i] = f[i-1] + f[i-2];

        System.out.println(f[n]);
        System.out.println(n - 2);
    }
}
