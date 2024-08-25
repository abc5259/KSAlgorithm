/**
 * 1912 - 연속합 [성공|00:15:12]
 * 실버2, 누적합, 시도2
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912 {
    // 시간제한 1초, 메모리제한 128MB
    // n개의 정수로 이루어진 임의의 수열
    // 이 중 연속된 몇 개의 수를 선택해 구할 수 있는 합 중 가장 큰 합을 구하자.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n+1];
        A[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            A[i] = Math.max(A[i-1] + A[i], A[i]);
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++)
            ret = Math.max(A[i], ret);

        System.out.println(ret);
    }
}
