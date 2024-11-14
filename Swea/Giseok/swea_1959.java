/**
 * 1959. 두 개의 숫자열 (D2|구현) [O|00:14:34]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] n = new int[2];
            n[0] = Integer.parseInt(st.nextToken());
            n[1] = Integer.parseInt(st.nextToken());

            int[][] ab = new int[2][];
            ab[0] = new int[n[0]]; ab[1] = new int[n[1]];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n[i]; j++) ab[i][j] = Integer.parseInt(st.nextToken());
            }

            int ret = 0;
            int maxn = Math.max(n[0], n[1]);
            int minn = Math.min(n[0], n[1]);
            for (int i = 0; i <= maxn - minn; i++) {
                int sum = 0;
                for (int j = 0; j < minn; j++) {
                    if (n[0] > n[1]) sum += (ab[0][j + i] * ab[1][j]);
                    else sum += (ab[0][j] * ab[1][j + i]);
                }
                ret = Math.max(sum, ret);
            }

            System.out.println("#" + t + " " + ret);
        }
    }
}