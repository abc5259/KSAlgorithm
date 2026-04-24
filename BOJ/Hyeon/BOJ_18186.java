package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long[] arr = new long[N + 2];

        st = new StringTokenizer(br.readLine());
        long totalSum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            totalSum += arr[i];
        }

        if (B <= C) {
            System.out.println(totalSum * B);
            return;
        }

        long ans = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                continue;
            }

            if (arr[i + 1] > arr[i + 2]) {
                long cnt = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                ans += cnt * (B + C);
                arr[i] -= cnt;
                arr[i + 1] -= cnt;

                long cnt2 = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                ans += cnt2 * (B + 2 * C);
                arr[i] -= cnt2;
                arr[i + 1] -= cnt2;
                arr[i + 2] -= cnt2;
            } else {
                long cnt = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
                ans += cnt * (B + 2 * C);
                arr[i] -= cnt;
                arr[i + 1] -= cnt;
                arr[i + 2] -= cnt;

                long cnt2 = Math.min(arr[i], arr[i + 1]);
                ans += cnt2 * (B + C);
                arr[i] -= cnt2;
                arr[i + 1] -= cnt2;
            }

            ans += arr[i] * B;
            arr[i] = 0;
        }

        System.out.println(ans);
    }
}
// D5 라면 사기 (Large) 그리디
// 못품 걍 답봄.
// B <= C 인 경우에는 묶음 할인이 적용되지 않거나 오히려 손해이므로 모든 라면을 B로 사고
// B > C 인 경우에는 최대한 3개로 묶어 삼
// arr[i+1] > arr[i+2] 일 때 먼저 3개로 묶어버리면 arr[i+1]만 남아서 B로 사는 손해
// 따라서 arr[i+1] - arr[i+2]만큼 arr[i]와 B+C로 텀 그 외 3개 묶음 삼
// 남는 arr[i]는 B로 구매