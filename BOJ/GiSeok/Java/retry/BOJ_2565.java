/**
 * 2565 - 전깃줄 [실패|00:52:17]
 * 골드5, LIS, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] cable = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cable[i][0] = Integer.parseInt(st.nextToken());
            cable[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cable, (Comparator.comparingInt(o -> o[0])));

        int[] lis = new int[n];
        lis[0] = cable[0][1];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (cable[i][1] > lis[idx]) lis[++idx] = cable[i][1];
            else {
                int low = -1;
                int high = idx;

                while (low + 1 < high) {
                    int mid = (low + high) / 2;

                    if (lis[mid] >= cable[i][1]) high = mid;
                    else low = mid;
                }

                lis[high] = cable[i][1];
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++) if (lis[i] != 0) ret++;

        System.out.println(n - ret);
    }
}
