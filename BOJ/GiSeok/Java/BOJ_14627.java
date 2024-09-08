/**
 * 14627 - 파닭파닭 [성공(반례)|00:24:23]
 * 실버2, 이분탐색, 시도3
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14627 {
    // 시간제한 2초, 메모리제한 256MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int low = 0;
        int high = 1000000001;

        int[] leek = new int[s];
        for (int i = 0; i < s; i++)
            leek[i] = Integer.parseInt(br.readLine());

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            int cnt = 0;
            for (int i = 0; i < s; i++)
                cnt += (leek[i] / mid);

            if (cnt < c) high = mid;
            else low = mid;
        }

        long ret = 0;
        for (int i = 0; i < s; i++)
            ret += leek[i];

        ret -= ((long)low * c);
        System.out.println(ret);
    }
}
