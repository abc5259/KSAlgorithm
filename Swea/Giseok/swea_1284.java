/**
 * 1284. 수도 요금 경쟁 (D2|구현) [O]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int a = p * w;
            int b = w <= r ? q : q + (w - r) * s;
            System.out.println("#" + t + " " + (Math.min(a, b)));
        }
    }
}
