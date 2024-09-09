/**
 * 12015 - 가장 긴 증가하는 부분 수열 2 [실패]
 * 골드2, LCS, 시도6
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12015 {
    // 시간제한 3초, 메모리제한 512MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] lis = new int[n];
        lis[0] = A[0];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (lis[idx] < A[i]) lis[++idx] = A[i];
            else {
                int low = 0;
                int high = idx;

                while (low + 1 < high) {
                    int mid = (low + high) / 2;

                    if (lis[mid] >= A[i]) high = mid;
                    else low = mid;
                }

                lis[high] = A[i];
            }
        }

        int ret = 0;
        for (int i = 0; i < n+1; i++) if (lis[i] != 0) ret++;

        System.out.println(ret);
    }
}
