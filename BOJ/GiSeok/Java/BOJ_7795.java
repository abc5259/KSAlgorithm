/**
 * 7795 - 먹을 것인가 먹힐 것인가 [성공|01:05:45]
 * 실버3, 이분탐색, 시도2
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_7795 {
    // 시간제한 1초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] A = new int[n];
            int[] B = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(A);
            Arrays.sort(B);

            int ret = 0;
            for (int i = n-1; i >= 0; i--) {

                int low = -1;
                int high = m;

                while (low + 1 < high) {
                    int mid = (low + high) / 2;

                    if (B[mid] >= A[i]) high = mid;
                    else low = mid;
                }

                ret += high;
            }

            System.out.println(ret);
        }
    }
}
