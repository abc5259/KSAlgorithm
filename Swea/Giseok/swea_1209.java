/**
 * 1209. [S/W 문제해결 기본] 2일차 - Sum (D3|구현) [O|00:07:29]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1209 {

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int[][] arr = new int[100][100]; br.readLine();

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) arr[i][j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            // 각 행의 합
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) sum += arr[i][j];
                max = Math.max(sum, max);
            }

            // 각 열의 합
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) sum += arr[j][i];
                max = Math.max(sum, max);
            }

            // 대각선
            int sum = 0;
            for (int i = 0, j = 0; (i < 100 && j < 100); i++, j++) {
                sum += arr[i][j];
            }
            max = Math.max(sum, max);

            sum = 0;
            for (int i = 0, j = 99; (i < 100 && j >= 0); i++, j--) {
                sum += arr[i][j];
            }
            max = Math.max(sum, max);

            System.out.println("#" + tc + " " + max);
        }
    }
}