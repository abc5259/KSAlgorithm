/**
 * 2792 - 보석 상자 [실패|01:03:37]
 * 실버1, 이분탐색, 시도1
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2792 {
    // 시간제한 1초, 메모리제한 128MB

    static int[] jewel;
    static int n, m;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int low = 1;
        int high = 0;

        jewel = new int[m];
        for (int i = 0; i < m; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, jewel[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += (jewel[i] / mid);
                if (jewel[i] % mid != 0) cnt++;
            }

            if (cnt <= n) {
                ret = Math.min(mid, ret);
                high = mid - 1;
            } else low = mid + 1;
        }

        System.out.println(ret);
    }
}
