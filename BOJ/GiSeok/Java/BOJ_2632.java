/**
 * 2632 - 피자판매 [실패|01:53:24]
 * 골드2, 누적합, 시도8
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2632 {
    // 시간제한 2초, 메모리제한 128MB
    // 피자는 여러 개의 피자조각으로 나뉘어져 있다.
    // 피자가게는 한 피자에서 2조각 이상 판매하려면 무조건 연속된 조각들을 잘라 판매함.

    // 피자 A를 기준으로..

    static int ret = 0;
    static int[] A;
    static int[] B;
    static int m, n;
    static int pizza;
    static Map<Integer, Integer> mpa = new HashMap<>();
    static Map<Integer, Integer> mpb = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pizza = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        A = new int[m * 2 + 1];
        B = new int[n * 2 + 1];

        for (int i = 1; i <= m; i++) A[i] = A[i+m] = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) B[i] = B[i+n] = Integer.parseInt(br.readLine());

        for (int i = 1; i <= m * 2; i++) A[i] += A[i - 1];
        for (int i = 1; i <= n * 2; i++) B[i] += B[i - 1];

        int sum;

        for (int interval = 1; interval <= m; interval++) {
            for (int start = interval; start <= m + interval - 1; start++) {
                sum = A[start] - A[start - interval];
                if (!mpa.containsKey(sum)) mpa.put(sum, 1);
                else mpa.put(sum, mpa.get(sum) + 1);
                if (interval == m) break;
            }
        }

        for (int interval = 1; interval <= n; interval++) {
            for (int start = interval; start <= n + interval - 1; start++) {
                sum = B[start] - B[start - interval];
                if (!mpb.containsKey(sum)) mpb.put(sum, 1);
                else mpb.put(sum, mpb.get(sum) + 1);
                if (interval == n) break;
            }
        }

        if (mpa.containsKey(pizza))
            ret = mpa.get(pizza);
        if (mpb.containsKey(pizza))
            ret += mpb.get(pizza);
        for (int i = 1; i < pizza; i++)
            if (mpa.containsKey(i) && mpb.containsKey(pizza - i))
                ret += (mpa.get(i) * mpb.get(pizza - i));

        System.out.println(ret);
    }
}
