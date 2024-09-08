/**
 * 2776 - 암기왕 [성공|00:15:26]
 * 실버4, 이분탐색, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2776 {
    // 시간제한 2초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] A = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(br.readLine());
            int[] B = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(A);

            for (int i = 0; i < m; i++) {
                int low = -1;
                int high = n;

                while (low + 1 < high) {
                    int mid = (low + high) / 2;

                    if (A[mid] >= B[i]) high = mid;
                    else low = mid;
                }

                if (high == n || A[high] != B[i]) bw.write(0 + "");
                else bw.write(1 + "");
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}
