/**
 * 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기 (D2|구현) [O|00:08:27]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] scores = new int[101];
            for (int i = 0; i < 1000; i++) scores[Integer.parseInt(st.nextToken())]++;

            int cnt = 0;
            int ret = 0;
            for (int n = 0; n < 101; n++) {
                if (cnt <= scores[n]) {
                    ret = n;
                    cnt = scores[n];
                }
            }

            System.out.println("#" + tc + " " + ret);
        }
    }
}