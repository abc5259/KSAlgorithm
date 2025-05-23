package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);
    }
}

// S2 연속합 DP
// 걍 쉽게 풀었따 DP 메모이제이션 기초문제 왜냐면 누적해서 이전합+ 현재값 vs 현재값인데
// 앞의 값이 마이너스이거나 더 작을경우 이전값을 잊고 현재값으로 dp를 채워나가고 이전 값을 O(1) 로 불러와서
// 연산하기에 시간복잡도 측에서 유리