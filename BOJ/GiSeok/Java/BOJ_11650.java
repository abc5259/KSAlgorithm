/**
 * 11650 - 좌표 정렬하기(S5) [O|00:04:03]
 * 정렬, 시도2
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        for (int i = 0; i < n; i++)
            System.out.println(xy[i][0] + " " + xy[i][1]);
    }
}
