/**
 * [G4 누적합] 좋은 친구 - O, 00:42:39
 * 시도 3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] originalLength = new int[n];
        for (int i = 0; i < n; i++) originalLength[i] = br.readLine().length();

        int[][] len = new int[n+k+1][21];
        for (int i = 1; i <= n; i++) {
            int length = originalLength[i-1];
            for (int j = 1; j <= 20; j++) {
                if (length == j) len[i][j] = len[i - 1][j] + 1;
                else len[i][j] = len[i - 1][j];
            }
        }
        for (int i = n+1; i <= n+k; i++) {
            System.arraycopy(len[n], 1, len[i], 1, 20);
        }

        long ret = 0;
        for (int i = 1; i <= n; i++) ret += (len[i+k][originalLength[i-1]] - len[i][originalLength[i-1]]);

        System.out.println(ret);
    }
}
