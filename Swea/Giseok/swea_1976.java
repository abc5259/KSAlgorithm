/**
 * 1976. 시각 덧셈 (D2|구현) [O|00:05:12]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int h = (m1 + m2) / 60;
            int m = (m1 + m2) % 60;
            h = (h + h1 + h2) % 12;
            System.out.println("#" + t + " " + (h == 0 ? 12 : h) + " " + m);
        }
    }
}
