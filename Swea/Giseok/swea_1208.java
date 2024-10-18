/**
 * 1208. [S/W 문제해결 기본] 1일차 - Flatten (D3|구현) [O|00:08:26]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1208 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            int[] map = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) map[i] = Integer.parseInt(st.nextToken());

            for (int d = 0; d < dump; d++) {
                int maxIdx = 0;
                int minIdx = 0;
                for (int i = 0; i < 100; i++) {
                    if (map[minIdx] > map[i]) minIdx = i;
                    if (map[maxIdx] < map[i]) maxIdx = i;
                }

                map[maxIdx]--;
                map[minIdx]++;
            }

            int max = 0;
            int min = 101;
            for (int i = 0; i < 100; i++) {
                max = Math.max(max, map[i]);
                min = Math.min(min, map[i]);
            }

            System.out.println("#" + tc + " " + (max - min));
        }
    }
}