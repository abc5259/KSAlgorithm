/**
 * 1561 - 놀이 공원 [실패|01:30:34]
 * 골드1, 이분탐색, 시도8
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1561 {
    // 시간제한 2초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] play = new long[m];
        for (int i = 0; i < m; i++) play[i] = Integer.parseInt(st.nextToken());

        if (n <= m) System.out.println(n);
        else {

            long low = 0;
            long high = 30L * n + 1;

            while (low + 1 < high) {
                long mid = (low + high) / 2;

                long cnt = m;
                for (int i = 0; i < m; i++)
                    cnt += (mid / play[i]);

                if (cnt >= n) high = mid;
                else low = mid;
            }

            long ret = m;
            for (int i = 0; i < m; i++)
                ret += ((high-1) / play[i]);

            for (int i = 0; i < m; i++) {
                if (high % play[i] == 0) ret++;
                if (ret == n) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
