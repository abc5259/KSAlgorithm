/**
 * 00:06:16 S3
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] sum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i-1] + Integer.parseInt(st.nextToken()));
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            max = Math.max(max, sum[i] - sum[i - k]);
        }

        System.out.println(max);
    }
}
