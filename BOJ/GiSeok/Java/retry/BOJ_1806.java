package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = 1;
        int ans = Integer.MAX_VALUE;
        while (right <= n) {
            long mid = sum[right] - sum[left];

            if (mid >= s) {
                ans = Math.min(ans, right - left);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
