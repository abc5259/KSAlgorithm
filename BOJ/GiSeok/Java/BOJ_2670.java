/**
 * 2670 - 연속부분최대곱 [성공|00:10:12]
 * 실버4, 완전탐색, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;

public class BOJ_2670 {
    // 시간제한 1초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[] a = new double[n];
        for (int i = 0; i < n; i++) a[i] = Double.parseDouble(br.readLine());

        double ret = -1;
        for (int i = 0; i < n-1; i++) {
            double sum = 1;
            for (int j = i; j < n; j++) {
                sum *= a[j];
                ret = Math.max(ret, sum);
            }
        }

        System.out.println(String.format("%.3f", ret));
    }
}
