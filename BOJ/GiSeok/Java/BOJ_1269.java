/**
 * 1269 - 대칭 차집합 [성공|00:36:17]
 * 실버4, 이분탐색, 시도1
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1269 {
    // 시간제한 2초, 메모리제한 256MB
    // A-B면 A 원소 하나하나 반복하면서 B 원소 이분탐색으로 같은거찾기. 약 200,000 * 18 * 2 = 360만 * 2 = 720만

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] A = new int[n];
        int[] B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int low = -1;
            int high = m;
            while (low + 1 < high) {
                int mid = (low + high) / 2;

                if (B[mid] >= A[i]) high = mid;
                else low = mid;
            }

            if (low == m-1 || high < m && B[high] != A[i]) cnt++;
        }

        for (int i = 0; i < m; i++) {
            int low = -1;
            int high = n;
            while (low + 1 < high) {
                int mid = (low + high) / 2;

                if (A[mid] >= B[i]) high = mid;
                else low = mid;
            }

            if (low == n-1 || high < n && A[high] != B[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
