/**
 * 1072 - 게임 [성공(반례힌트)|00:31:13]
 * 실버3, 이분탐색, 시도6
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1072 {
    // 시간제한 2초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());

        long z = (long)(y * 100 / x);

        long low = 0;
        long high = Integer.MAX_VALUE;

        while (low + 1 < high) {
            long mid = (low + high) / 2;

            double a = y + mid;
            double b = x + mid;
            long Z = (long)((a / b) * 100);

            if (Z - z >= 1) high = mid;
            else low = mid;
        }

        long ret = high;
        if (ret == Integer.MAX_VALUE) ret = -1;
        System.out.println(ret);
    }
}
