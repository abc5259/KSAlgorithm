/**
 * 14003 - 가장 긴 증가하는 부분 수열 5 [실패|02:18:54]
 * 플래5, LIS/이분탐색, 시도5
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14003 {
    // 시간제한 3초, 메모리제한 512MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] lis = new int[n];
        Arrays.fill(lis, Integer.MIN_VALUE);
        int[] pos = new int[n];
        lis[0] = A[0]; int idx = 0;
        pos[0] = 0;

        for (int i = 0; i < n; i++) {
            if (lis[idx] < A[i]) {
                lis[++idx] = A[i];
                pos[i] = idx;
            } else {
                int low = -1;
                int high = idx;

                while (low + 1 < high) {
                    int mid = (low + high) / 2;

                    if (lis[mid] >= A[i]) high = mid;
                    else low = mid;
                }

                lis[high] = A[i];
                pos[i] = high;
            }
        }

        int ret = 0;
        for (int i = 0; i < n; i++) if (lis[i] != Integer.MIN_VALUE) ret++;

        System.out.println(ret);

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for (int i = n-1; i >= 0; i--) {
            if (pos[i] == ret-1) {
                stk.push(A[i]);
                ret--;
            }
        }

        while (!stk.isEmpty()) System.out.print(stk.pop() + " ");
        System.out.println();
    }
}
