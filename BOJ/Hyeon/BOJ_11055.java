package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = A[0];

        for (int i = 0; i < N; i++) {
            dp[i] = A[i];
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}

// S2 가장 큰 증가하는 부분 수열 DP
// 쉽게 풀었다.
// LIS 생각 기반해서 풀었고 이전까지의 DP 값을 저장하는 것과 기존에 주어지는 A 수열을 2개의 배열로 이용해야한다.
// 최장 증가 부분 수열 Longest Increasing Subsequence 라서 오름차순으로 정렬된 가장 긴 수열이다
// 항상 ON^2로 풀고있다 DP라서

// 바텀 업 방식을 채택해서 N의 수를 엣지케이스부터 시작하여 점화식을 구하였다
// i 번째 원소의 위체에서 가질 수 있는 LIS 의 값은 본인 자체이고 두번째부터는 본인보다 작은 이전값의 DP중 큰 값을 가지고 오는 것이다.
