package BOJ.Hyeon.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

        // 역추적 시작
        while (max > 0) {
            if (dp[N - 1] == max) {
                sb.insert(0, arr[N - 1] + " ");
                max--;
            }
            N--;
        }
        System.out.println(sb);
    }
}

// G4 가장 긴 증가하는 부분 수열 4 DP
// stack 자료구조를 고려하지 못했고 sb insert 를 써서 했다
// 그리고 max가 0이 아닐 때라는 것을 역추적으로 활용하였다.
// while 문 전까지는 그냥 LIS 최장거리 라고 생각해서 풀었다 현재 값이 나보다 작고 dp에 저장된 값이 나보다 크거나 같을 때 새로운
// 값을 저장하는게 LIS 이고 여기서 역추적을 화용해서 N을 줄여나가게 했다.