package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + arr[j]);
            }
        }
        System.out.println(dp[N]);
    }
}

// S1 카드 구매하기 DP
// 다시 풀어봤다
// DP의 1 Based 와 O Based에 대해서 고민 하였다
// 문제에서 제기하는 N개는 1부터 시작하기 때문에 배열의 크기를 N+1로 잡아서 인덱싱을 관리한다.
// DP 문제는 N개의 아이템 K 번째 단계 처럼 1부터 시작되는 개념이 많아서 점화식이 간결해진다.