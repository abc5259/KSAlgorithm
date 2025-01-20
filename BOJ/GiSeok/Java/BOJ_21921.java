/**
 * [S3 누적합] 블로그 - O, 00:07:08
 * 시도 2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] visitor = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) visitor[i] = (Integer.parseInt(st.nextToken()) + visitor[i-1]);

        int max = 0;
        int day = 0;
        for (int i = x; i <= n; i++) {
            if (max < visitor[i] - visitor[i - x]) {
                max = visitor[i] - visitor[i - x];
                day = 0;
            }
            if (max == visitor[i] - visitor[i - x]) day++;
        }

        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(day);
        }
    }
}
