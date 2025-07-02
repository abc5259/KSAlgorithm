/**
 * 00:07:52 B2
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] cars = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            for (int p = from; p < to; p++) {
                cars[p]++;
            }
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            switch (cars[i]) {
                case 1:
                    sum += a;
                    break;
                case 2:
                    sum += (2 * b);
                    break;
                case 3:
                    sum += (3 * c);
            }
        }

        System.out.println(sum);
    }
}
