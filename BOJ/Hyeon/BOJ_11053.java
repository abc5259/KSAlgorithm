package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

// S2 가장 긴 증가하는 부분 수열 DP
// 일단 풀었다. 이전 DP와의 값비교가 있어야 되기에 2중 반복문을 사용하고
// 최소한 길이를 제공하기위해 DP 배열의 모든 값을 1로 초기화 시킨다
// 그리고 max 를 통해 가장 긴 부분의 dp를 구한다.