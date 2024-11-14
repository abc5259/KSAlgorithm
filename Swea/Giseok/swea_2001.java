/**
 * 2001. 파리 퇴치 (D2|누적합) [O]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_2001 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n+1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] += map[i][j-1] + Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int y = 0; y <= n - m; y++) {
                for (int x = m; x <= n; x++) {
                    int sum = 0;
                    for (int yy = y; yy < y + m; yy++) {
                        sum += map[yy][x] - map[yy][x - m];
                    }
                    max = Math.max(sum, max);
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}