package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2565 {
    static final int MAX = 501;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] lines = new int[MAX];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[a] = b;
        }

        int[] dp = new int[MAX];
        int max = 0;

        for (int i = 1; i < MAX; i++) {
            if (lines[i] != 0) {
                dp[i] = 1;
                for (int j = 1; j < i; j++) {
                    if (lines[j] < lines[i] && dp[j] >= dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.print(N - max);
    }
}
// G5 전깃줄 DP
// LIS 이다 가장 긴 부분 수열인데
// 전깃줄을 1부터 시작해서 500이 최대니까 500까지 순서대로 해서 1번 전깃줄 2번 전깃줄 순서대로 가다가
// 이전 전깃줄과 안겹치게 더 길게 있으면 이전 전깃줄이 가진 개수 + 1을하는 LIS를 쓰면된다.
// 지워야되는 전깃줄이라서 만들 수 있는 전깃줄을 전체에서 빼면된다.
// 일단 lines 라는 1개의 전깃줄 배열을 만들어서 값으로 비교하면 된다.
