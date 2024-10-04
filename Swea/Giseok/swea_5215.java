/**
 * 5215. 햄버거 다이어트(D3/완탐) [O|00:12:40]
 * 시도1
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_5215 {

    static int[] cal;
    static int[] point;
    static int p, k;

    static int go(int idx, int kcal, int sum) {

        if (kcal > k) return 0;
        if (idx == p) return sum;

        int ret = go(idx + 1, kcal + cal[idx], sum + point[idx]);
        ret = Math.max(ret, go(idx + 1, kcal, sum));

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            point = new int[p];
            cal = new int[k];
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                point[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println("#" + tc + " " + go(0, 0, 0));
        }
    }
}
