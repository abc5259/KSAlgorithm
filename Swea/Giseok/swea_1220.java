/**
 * 1220. [S/W 문제해결 기본] 5일차 - Magnetic (D3|구현) [X|01:17:54+@]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1220 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] table = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ret = 0;
            for (int x = 0; x < 100; x++) {
                int state = 0;
                for (int y = 0; y < 100; y++) {
                    if (table[y][x] == 1) {
                        state = 1;
                    } else if (table[y][x] == 2 && state == 1) {
                        ret++;
                        state = 0;
                    }
                }
            }

            System.out.println("#" + tc + " " + ret);
        }
    }
}