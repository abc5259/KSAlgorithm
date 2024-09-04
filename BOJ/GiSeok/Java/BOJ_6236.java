/**
 * 6236 - 용돈 관리 [성공|00:34:58]
 * 실버2, 이분탐색, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6236 {
    // 시간제한 1초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int low = 0;
        int high = 0;

        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            high += money[i];
            low = Math.max(money[i], low);
        }

        int ret = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + money[i] > mid) { sum = 0; cnt++; }
                sum += money[i];
            }

            if (sum != 0) cnt++;

            if (cnt > m) low = mid + 1;
            else {
                ret = Math.min(ret, mid);
                high = mid - 1;
            }
        }

        System.out.println(ret);
    }
}
