package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = 1;

        int[] inc_dp = new int[N];
        inc_dp[0] = 1;
        for (int i = 1; i < N; i++) {
            inc_dp[i] = 1;
            if (arr[i - 1] <= arr[i]) {
                inc_dp[i] = inc_dp[i - 1] + 1;
            }
            len = Math.max(inc_dp[i], len);
        }

        int[] dec_dp = new int[N];
        dec_dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dec_dp[i] = 1;
            if (arr[i - 1] >= arr[i]) {
                dec_dp[i] = dec_dp[i - 1] + 1;
            }
            len = Math.max(dec_dp[i], len);
        }
        System.out.print(len);
    }
}
// S4 수열 DP
// LIS랑 LDS 를 하기전 사전 개념 이전까지의 수자랑 비교해서 연속해서 얼마나 가져갔냐를 묻는 것이다.
// 그래서 배열에다가 지금까지의 갯수를 누적해서 해도되고
// 공간 복잡도를 줄이려면 그냥 변수에다가 넣어서 비교하고 아니라면 1로 초기화하고 이런식으로 해도 될거같다.