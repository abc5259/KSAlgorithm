/**
 * 2343 - 기타레슨 [실패]
 * 실버1, 이분탐색
 */
package BOJ.GiSeok.Java;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2343 {
    // 시간제한 2초, 메모리제한 128MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] blueray = new int[n];

        int low = 1;
        int high = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            blueray[i] = Integer.parseInt(st.nextToken());
            high += blueray[i];
            low = Math.max(low, blueray[i]); // 제일 작은 값부터 시작하면 그냥 넘어버리는 원소에 대해서도 cnt++이 적용되어 미리 제일 큰 원소 값으로 셋팅
            // ex. mid = 400, m = 2
            // 100 300 400 500
            // 500에 대해서 cnt++ 됨.
            // 그래서 정답처리 된다.
        }

        int ret = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + blueray[i] > mid) { sum = 0; cnt++; }
                sum += blueray[i];
            }

            if (sum != 0) cnt++;

            if (cnt > m) low = mid + 1;
            else {
                ret = Math.min(mid, ret);
                high = mid - 1;
            }
        }

        System.out.println(ret);
    }
}
